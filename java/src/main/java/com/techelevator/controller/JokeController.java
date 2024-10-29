package com.techelevator.controller;

import com.techelevator.dao.JokeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.DBJoke;
import com.techelevator.model.User;
import com.techelevator.service.DadJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin (origins = "http://127.0.0.1:5173")
@PreAuthorize("isAuthenticated()")
public class JokeController {

    @Autowired // let spring handle the business... don't have to create constructors etc...
    private DadJokeService service;

    @Autowired
    private JokeDao jokeDao;

    @Autowired
    private UserDao userDao;

    @GetMapping("/joke")
    public String getJoke() {
        return service.getDadJoke();
    }
    @PostMapping("/joke")
    public ResponseEntity<Void> saveJoke(@RequestBody DBJoke joke, Principal principal) {
        System.out.println(joke.getJoke());
        System.out.println();
        User user = userDao.getUserByUsername(principal.getName());
        jokeDao.saveJoke(joke.getJoke(), user.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
