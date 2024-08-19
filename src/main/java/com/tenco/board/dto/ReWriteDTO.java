package com.tenco.board.dto;

import com.tenco.board.repository.model.Boarder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReWriteDTO {
	
	private Integer id;
	private String title;
	private String contents;
	private String username;
	
	public Boarder toWriter() {
		return Boarder.builder()
				.id(this.id)
				.title(this.title)
				.contents(this.contents)
				.username(this.username)
				.build();
	}
}	
	
