package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Album;

public interface AlbumService {

	int save(Album a);
	
	Album fetch(int id);
	
	List<Album> list();
	
	boolean remove(int id);
	
	List<Album> byGenre(String genre);
	
	Album byTitle(String title);
	
	List<Album> byArtist(String artist);
}
