package com.complotBack.complot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
	
	@NotNull
	@Size(max=50)
	private String username;
	
}
