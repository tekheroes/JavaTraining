package com.tekheroes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Flight {
	@Id
	private int code;
	@Column(length = 20)
	private String carrier;
	@Column(name = "source", length = 20)
	private String source;
	@Column(name = "destination", length = 20)
	private String destiny;
	
}
