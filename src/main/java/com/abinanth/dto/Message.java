package com.abinanth.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(value = Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Message {

	private String infoMessage;
	private String errorMessage;

}
