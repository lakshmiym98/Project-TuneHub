package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@CrossOrigin("*")
@RestController
public class SongController {
	@Autowired
	SongService songService;
	@PostMapping("/addsong")

	public String addsong(@ModelAttribute Song song) {
		String name=song.getName();
		boolean status = songService.songExists(name);
		if(status==false){
			songService.addsong(song);
			System.out.println("song added successfully");
		}else {
			System.out.println("song already exists");
		}	 
		return "adminhome";		
	}
	
//	@GetMapping("/viewsongs")
//	public String viewsongs(Model model) {
//		List<Song> songlist=songService.fetchAllSongs();
//		model.addAttribute("songs", songlist);
//		return "displaysongs";
//	}
//	
	
	@GetMapping("/viewsongs")
	public @ResponseBody List<Song> viewSongs(){
		return songService.fetchAllSongs();
	}
	
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium = false;
		if(premium) {
		List<Song> songlist=songService.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "displaysongs";
		}
		else {
			return "subscriptiongform";
		}
	}
	
}