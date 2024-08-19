package com.tenco.board.dto;

import com.tenco.board.repository.model.Writer;

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
public class WriterDTO {

	private String title;
	private String contents;
	private String username;
	
	public Writer toWriter(String name) {
		return Writer.builder()
				.title(this.title)
				.contents(this.contents)
				.username(name)
				.build();
	}
	

}
