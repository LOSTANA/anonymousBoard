package com.tenco.board.repository.model;

import org.springframework.http.HttpStatus;

import com.tenco.board.handler.exception.DataDeliveryException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Boarder {
	private Integer id;
	private String title;
	private String contents;
	private String username;
	
	public void checkUser(String username) {
		if(this.username != username) {
			throw new DataDeliveryException("글쓴이가 아닙니다", HttpStatus.BAD_REQUEST);
		}
	}
}
