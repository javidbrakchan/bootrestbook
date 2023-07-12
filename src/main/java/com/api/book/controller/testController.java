package com.api.book.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {
	@RequestMapping(value="/books",method=RequestMethod.GET)
	@ResponseBody
public String getBooks() {
	return "this is testing book first";
}
}
