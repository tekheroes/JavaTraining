package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.entity.Album;
import com.tekheroes.repo.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumRepository repo;

	@Override
	public int save(Album a) {
		repo.save(a);
		return a.getAlbId();
	}

	@Override
	public Album fetch(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Album> list() {
		return repo.findAll();
	}

	@Override
	public boolean remove(int id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Album> byGenre(String genre) {
		return repo.findByGenre(genre);
	}

	@Override
	public Album byTitle(String title) {
		return repo.findByTitle(title);
	}

	@Override
	public List<Album> byArtist(String artist) {
		return repo.findByArtist(artist);
	}
}
