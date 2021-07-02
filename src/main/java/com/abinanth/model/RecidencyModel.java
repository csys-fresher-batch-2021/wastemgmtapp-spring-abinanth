package com.abinanth.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecidencyModel {

	private String recidencyType;

}
