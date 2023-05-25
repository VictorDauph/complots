package com.complotBack.complot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLoginDto {

	@NotNull
	String username;
}
