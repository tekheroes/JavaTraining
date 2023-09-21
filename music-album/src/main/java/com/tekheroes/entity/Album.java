package com.tekheroes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
	
	public int getAlbId() {
		return albId;
	}
	public void setAlbId(int albId) {
		this.albId = albId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
