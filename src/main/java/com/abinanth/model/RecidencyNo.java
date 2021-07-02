package com.abinanth.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RecidencyNo {
	private int recidencyNo;
	private int year;
	private String recidencyType;

}
