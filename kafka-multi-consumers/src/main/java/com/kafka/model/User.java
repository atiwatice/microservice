package com.kafka.model;

import lombok.Data;

@Data
public class User {
	private long userId;
    private String firstName;
    private String lastName;
}
