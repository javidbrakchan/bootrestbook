package com.api.book.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/uploadfile/path/{path}")
	//file is interface which receives files
	public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file,@PathVariable("path") String path){
		System.out.println("encoded path "+path);
		byte[] decodedBytes = Base64.getDecoder().decode(path);
		String decodedString = new String(decodedBytes);
		System.out.println("decoded Path "+decodedString);
		try {
		//validation
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain files");
		}
		
		//
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg type allowed");
		}
		
		//upload file
		if(fileUploadHelper.uploadFile(file,decodedString)) {
			return ResponseEntity.ok("file is succesfully uploaded");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
	}
}
