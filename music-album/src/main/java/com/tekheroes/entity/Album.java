package com.tekheroes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Album {
	@Id
	@Column(name = "alb_id")
	private int albId;
	@Column(length = 20)
	private String title;
	@Column(length = 20)
	private String artist;
	@Column(length = 20)
	private String genre;
	
}
