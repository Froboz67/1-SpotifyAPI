package com.techelevator.controller;

import com.techelevator.dao.ArtistDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import com.techelevator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@PreAuthorize("isAuthenticated()")
public class SpotifyController {

    @Autowired
    private SpotifyService service; // autowiring puts spring in charge

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArtistDao artistDao;

    @GetMapping("/artist/{name}")
    public Artist getArtist(@PathVariable String name) {
        return service.getArtist(name);
    }

    @PostMapping("/artist")
    public void saveArtist(@RequestBody Artist artist, Principal principal) {
        User user = userDao.getUserByUsername(principal.getName());
        artistDao.saveArtist(artist,  user.getId());
    }
    @GetMapping("/album")
    public Album getAlbum(@PathVariable String albumName) {
        return service.getAlbum(albumName);
    }
}
