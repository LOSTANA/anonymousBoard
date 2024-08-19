package com.tenco.board.dto;

import com.tenco.board.repository.model.User;

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
public class MakenicknameDTO {

	private String name;
	
	public User toUser() {
		return User.builder()
				.name(this.name)
				.build();
	}
	
}
