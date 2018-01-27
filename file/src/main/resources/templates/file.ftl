<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css_common/iview/iview.css">
<script src="${path}/js_common/vue/vue.js"></script>
<script src="${path}/js_common/vue/vue.min.js"></script>
<script src="${path}/js_common/iview/iview.js"></script>
<script src="${path}/js_common/iview/iview.min.js"></script>
<script src="${path}/js_common/jquery/jquery-3.3.1.js"></script>
<script src="${path}/js_common/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	var vue;
	$(function() {
		vue = new Vue({
			el : "#main",
			data : {

			},
			methods : {
				"download" : function() {
					var iframe = document.createElement("iframe");
					iframe.src = "http://127.0.0.1:9001/file/download";
					iframe.style.display = "none";
					document.body.appendChild(iframe);
				}
			}
		});
	})
</script>
</head>
<body>
	<div id="main">
		<Upload multiple type="drag"
			action="http://127.0.0.1:9001/file/upload">
		<div style="padding: 20px 0">
			<Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
			<p>Click or drag files here to upload</p>
		</div>
		</Upload>
		<a @click="download">下载</a>
	</div>
</body>
</html>