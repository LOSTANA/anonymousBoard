package com.tenco.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tenco.board.dto.MakenicknameDTO;
import com.tenco.board.dto.ReWriteDTO;
import com.tenco.board.dto.WriterDTO;
import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.repository.model.Boarder;
import com.tenco.board.repository.model.User;
import com.tenco.board.service.BoardService;
import com.tenco.board.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final HttpSession session;
	private UserService userService = new UserService();
	private final BoardService listService;
	private Boarder boarder;

	MakenicknameDTO dto = new MakenicknameDTO();
	private String principal = userService.createUser();

	@GetMapping({ "/main-page", "/index" })
	public String Mainpage() {

		java.util.List<Boarder> boardList = listService.readAll();
		if (boardList.isEmpty()) {
			session.setAttribute("boardList", null);
		} else {
			session.setAttribute("boardList", boardList);

		}
		System.out.println("MainPage 호출");

		session.setAttribute("principal", principal);

		return "/main";
	}

	@PostMapping({ "/main-page", "/index" })
	public String Mainproc() {

		principal = userService.createUser();

		java.util.List<Boarder> boardList = listService.readAll();
		if (boardList.isEmpty()) {
			session.setAttribute("boardList", null);
		} else {
			session.setAttribute("boardList", boardList);

		}
		System.out.println("MainPage 호출");

		session.setAttribute("principal", principal);

		return "redirect:/main-page";
	}

	@GetMapping("/board")
	public String writePage() {
		return "/board";
	}

	@PostMapping("/board")
	public String writeProc(WriterDTO dto, @SessionAttribute("principal") User principal) {
		if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
			throw new DataDeliveryException("제목을 입력하세요!", HttpStatus.BAD_REQUEST);
		}
		if (dto.getContents() == null || dto.getContents().isEmpty()) {
			throw new DataDeliveryException("내용을 1글자 이상 입력하세요", HttpStatus.BAD_REQUEST);
		}

		listService.createContents(dto, principal.getName());

		return "redirect:/main-page";
	}

	@GetMapping("/updateBoard/{id}")
	public String reWritePage(
			@PathVariable(name = "id") Integer id,
			@SessionAttribute("principal") User principal,
			Model model) {

		boarder = listService.findBySome(id, principal.getName());
		model.addAttribute("boarder", boarder);
		
		return "/updateBoard";
	}
	
	@PostMapping("/updateBoard/{id}")
	public String reWriteProc(ReWriteDTO dto,

			@PathVariable(name = "id") Integer id,	
			@SessionAttribute("principal") User principal
		) {


	

		if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
			throw new DataDeliveryException("제목을 입력하세요!", HttpStatus.BAD_REQUEST);
		}
		if (dto.getContents() == null || dto.getContents().isEmpty()) {
			throw new DataDeliveryException("내용을 1글자 이상 입력하세요", HttpStatus.BAD_REQUEST);
		}
		System.out.println("저장출력되는 id : " + id);
		
		listService.reWriteContents(dto,principal.getName());
		
		return "redirect:/main-page";
	}


}
