package com.active.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
	private String id;
	private String name;
	private Integer age;
}
