package com.spring.web.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.board.service.BoardService;
import com.spring.web.vo.boardVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/board/list")
	public String list(@ModelAttribute("searchVO") boardVO searchVO, Model model) {
		
		
		List<boardVO> boardList = boardService.getList(searchVO);
		
		model.addAttribute("boardList",boardList);
		
		return "/board/list";
	}
	
	
	@GetMapping(value = "/board/create")
		public String create(@ModelAttribute("searchVO") boardVO searchVO, Model model) {
		
		log.info("request create");
		
		return "/board/create";
				
	}
	
	
	@PostMapping(value = "/board/create_action")
	public String create_action(@ModelAttribute("searchVO") boardVO searchVO, RedirectAttributes redirect) {
		
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
				
		Date time = new Date();
				
		String time1 = format1.format(time);
		searchVO.setBoard_regdate(time1);
		
		boardService.insertBoard(searchVO);
		
		redirect.addFlashAttribute("redirect", searchVO.getBoard_idx());
		
		return "redirect:/board/list";
	}
	
	
	

}