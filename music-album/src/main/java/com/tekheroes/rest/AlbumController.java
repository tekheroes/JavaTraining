package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.entity.Album;
import com.tekheroes.service.AlbumService;

@CrossOrigin
@RestController
public class AlbumController {

	@Autowired
	private AlbumService service;

	@PostMapping(value = "/album", consumes = "application/json")
	public String add(@RequestBody Album a) {
		int id = service.save(a);
		return "Album added with Id: " + id;
	}

	@GetMapping(value = "/album/{id}", produces = "application/json")
	public Album get(@PathVariable int id) {
		return service.fetch(id);
	}

	@GetMapping(value = "/albums", produces = "application/json")
	public List<Album> list() {
		return service.list();
	}

	@DeleteMapping(value = "/album/del/{id}")
	public String del(@PathVariable int id) {
		return service.remove(id) ? "Album deleted" : "Invalid Album Id";
	}

	// http://localhost:8880/album/title/RockOn
	@GetMapping(value = "/album/title/{title}", produces = "application/json")
	public Album byTitle(@PathVariable String title) {
		return service.byTitle(title);
	}

	// http://localhost:8880/albums/artist/MJ
	@GetMapping(value = "/albums/artist/{artist}", produces = "application/json")
	public List<Album> byArtist(@PathVariable String artist) {
		return service.byArtist(artist);
	}

	// http://localhost:8880/albums/genre/Pop
	@GetMapping(value = "/albums/genre/{genre}", produces = "application/json")
	public List<Album> byGenre(@PathVariable String genre) {
		return service.byGenre(genre);
	}
}
