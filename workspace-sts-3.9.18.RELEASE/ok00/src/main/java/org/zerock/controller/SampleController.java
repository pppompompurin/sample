package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample/*")

public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic............................");
	}
	
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic Get..........");
	}
	
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.......................");
	}
	
	@GetMapping("/ex01")             // /sample/ex01?name=aaa&age=30
	public String ex01(SampleDTO dto) {
		log.info("" + dto);		
		return "ex01";
	}
	
	@GetMapping("/ex02")            // /sample/ex02?name=aaa&age=30
	public String ex02(@RequestParam("name") String name, @RequestParam("age")int age) {
		log.info("name:"+name);
		log.info("age:"+age);
		return "ex02";
	}
	
	
	@GetMapping("/ex02_2")            // /sample/ex02_2?name=aaa&age=30
	public String ex02_2(String name, int age) {
		log.info("name:"+name);
		log.info("age:"+age);
		return "ex01";
	}
	
	
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids:"+ids);
		return "ex02List";
	}
	
	@GetMapping("ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids:" + Arrays.toString(ids));		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos:" + list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info("dto:" + dto);
		log.info("page:"+ page);
		model.addAttribute("page", page);
		
		return "/sample/ex04";
	}
	
	
	@GetMapping("/ex04_4")
	public String ex04_4(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto:" + dto);
		log.info("page:"+ page);
		
		return "/sample/ex04";
	}
	
	
	@GetMapping("/ex08")
	public String ex08() {
		log.info("/ex08.........................");
		return "redirect:/sample/ex09";
	}
	
	@GetMapping("/ex09")
	public void ex09() {
		log.info("/ex09.........................");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06...........");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("ȫ�浿");
		return dto;
	}
	

}
