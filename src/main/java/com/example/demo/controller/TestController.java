package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/views")
public class TestController {

		@RequestMapping("/test")
		public String test() {
			return "/views/test";
			
		}
		
		@RequestMapping("/test1")
		public String test1() {
			return "/views/test1";
			
		}

}

