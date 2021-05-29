package com.project.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...");
	}
	
	@PostMapping("/exUploadPost")
	public String exUploadPost(ArrayList<MultipartFile> files ) {
		files.forEach(file -> {
			log.info("---------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			
			File saveFile = new File("C:\\ftmp\\storage", file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				log.info(e.getMessage());
			}
			
		});
		
		return "redirect:/sample/exUpload";
	}
}
