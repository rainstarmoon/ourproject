package com.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.web.session.HttpServletSession;
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
	public Object downloadFile(final OutputStream out, HttpServletRequest request) {
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
		return downloadFile;
	}

}
