package com.tenco.board.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.handler.exception.RedirectException;


@ControllerAdvice  // IoC 대상 (싱글톤 패턴) --> HTML 렌더링 예외에 많이 사용
public class GlobalControllerAdvice {
	 
	@ResponseBody
	@ExceptionHandler(DataDeliveryException.class)
	public String dataDeleveryExcption(DataDeliveryException e) {
		StringBuffer sb = new StringBuffer();
		sb.append(" <script>");
		sb.append(" alert('"+ e.getMessage()  +"');");
		sb.append(" window.history.back();");
		sb.append(" </script>");
		return sb.toString(); 
	}
	

	@ExceptionHandler(RedirectException.class)
	public ModelAndView redirectException(RedirectException e) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("statusCode", e.getStatus().value());
		modelAndView.addObject("message", e.getMessage());
		return  modelAndView; // 페이지 반환 + 데이터 내려줌 
	}
	
}
