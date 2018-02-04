package com.project.base.config;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.project.base.util.LogUtil;

@Aspect
@Component
public class LogInterceptor {

	@Pointcut("@annotation(com.project.base.config.OurProjectLog)")
	public void logAnnotation() {

	}

//	@Before("logAnnotation()")
	public void doBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		
	}

//	@After("logAnnotation()")
	public void doAfter(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
	}

//	@AfterReturning(pointcut = "logAnnotation()", returning = "retVal")
	public void doAfterReturning(JoinPoint joinPoint, Object retVal) {
		String methodName = joinPoint.getSignature().getName();
		
	}

//	@AfterThrowing(pointcut = "logAnnotation()", throwing = "exception")
	public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
		String methodName = joinPoint.getSignature().getName();
		
	}

	@Around(value = "logAnnotation()")
	public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		//日志信息
		StringBuilder message=new StringBuilder();
		//方法名
		String methodName = joinPoint.getSignature().getName();
		//方法名写入
		message.append(methodName);
		message.append("\t");
		//方法参数列表
		Object[] args = joinPoint.getArgs();
		//参数写入
		message.append(analyzeObject(args));
		//方法开始时间
		long start = System.currentTimeMillis();
		//方法返回值
		Object proceed=null;
		try {
			//方法执行
			proceed = joinPoint.proceed();
			message.append("\nreturnValue:"+analyzeObject(proceed));
		} catch (Exception e) {
			//方法异常日志打印工具
			LogUtil.printExceptionLog(joinPoint.getTarget().getClass(), message.toString(), e);
			throw e;
		}
		//方法结束时间
		long end = System.currentTimeMillis();
		message.append("\n方法运行时间："+(end-start)+"ms");
		//方法正常日志打印工具
		LogUtil.printNoneExceptionLog(joinPoint.getTarget().getClass(), message.toString());
		return proceed;
	}
	
	//参数直接打印类型
	private static String[] types = {
			"int", 
	        "double", 
	        "long", 
	        "short", 
	        "byte",  
	        "boolean", 
	        "char", 
	        "float",
			"java.lang.Integer",
			"java.lang.Double",  
	        "java.lang.Float",
	        "java.lang.Long",
	        "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.Char",  
	        "java.lang.String",
	        "java.math.BigDecimal",
	        "org.bson.types.ObjectId"
	};
	
	//参数类型判断
	private Boolean judgeParam(Object object) {
		for (String t : types) {  
            if (t.equals(object.getClass().getName())) {  
            	return true;
            }  
        }
		return false;
	}
	
	
	
	//参数列表解析
	private String analyzeObject(Object[] args) {
		StringBuilder argsVal = new StringBuilder();
		for (Object object : args) {
			argsVal.append(analyzeObject(object));
		}
		return argsVal.toString();
	}
	
	//自定义对象解析
	private String analyzeObject(Object object) {
		StringBuilder argsVal = new StringBuilder();
		if(object==null) {
			argsVal.append("null");
			argsVal.append(",");
		}else if(judgeParam(object)) {
			argsVal.append(object.getClass().getName());
			argsVal.append(" ");
			argsVal.append(object.toString());
			argsVal.append(",");
		}else{
			argsVal.append(object.getClass().getName());
			argsVal.append(" [");
			Class<?> clazz = object.getClass();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get") && !method.getName().endsWith("Class")) {
					try {
						argsVal.append(method.getName().substring(3));
						argsVal.append(" ");
						Object invoke = method.invoke(object);
						argsVal.append(object2String(invoke));
						argsVal.append(",");
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			argsVal.append("],");
		}
		return argsVal.toString();
	}
	
	//对象转String
	private String object2String(Object obj) {
		if(obj==null) {
			return null;
		}else if(judgeParam(obj)) {
			return obj.toString();
		}else if(obj instanceof List) {
			return obj.getClass().getName()+" "+(((List<?>) obj).size());
		}else if(obj instanceof Map) {
			return obj.getClass().getName()+" "+(((Map<?,?>) obj).size());
		}else {
			return obj.getClass().getName();
		}
	}
	
}
