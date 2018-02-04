package com.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FastFileStorageClient storageClient;

	@RequestMapping("/upload")
	public Object uploadFile(MultipartFile file, HttpServletRequest request) {
		StorePath storePath = null;
		try {
			storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
					FilenameUtils.getExtension(file.getOriginalFilename()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("file", storePath);
		return storePath;
	}

	@RequestMapping("/download")
	public Object downloadFile(HttpServletRequest request, final OutputStream out) throws Exception {
		//response.reset();
		//response.setCharacterEncoding("GBK");
//		response.setContentType("application/force-download");
//		//response.setHeader("Connection", "close");
//		try {
//			response.setHeader("Content-Disposition",
//					"attachment;fileName=" + new String("aa".getBytes("GBK"), "ISO-8859-1"));
//		} catch (UnsupportedEncodingException e2) {
//			e2.printStackTrace();
//		}
//		response.setHeader("Content-Type", "application/octet-stream");
		/*OutputStream out1 = null;
		try {
			out1 = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		final OutputStream out = out1;*/
		StorePath storePath = (StorePath) request.getSession().getAttribute("file");
		String downloadFile = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(),
				new DownloadCallback<String>() {
					@Override
					public String recv(InputStream ins) throws IOException {
						try {
							IOUtils.copy(ins, out);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return "";
					}
				});
		//out.close();
		return downloadFile;
	}

}
