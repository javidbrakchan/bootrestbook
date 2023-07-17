package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String UPLOAD_DIR="D:\\Applications\\SpringBootWorkspace\\GithubWorkspace\\bootrestbook\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartfile,String path) {
		boolean f=false;
		try {
			
//			InputStream is=multipartfile.getInputStream();
//			byte data[]=new byte[is.available()];//stores input data in bytes
//			is.read(data);//it reads the data
//			
//			//write
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			//shortcut for above
			Files.copy(multipartfile.getInputStream(),Paths.get(path+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
			
		}catch (Exception e) {
		
		}
		return f;
	}
}
