package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.FavouriteMovie;
import com.example.demo.service.FavouriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping
    public void addToFavourites(@RequestParam Long userId, @RequestParam Long movieId) {
        favouriteService.addToFavourites(userId, movieId);
    }
    @GetMapping("/{id}")
    public List<FavouriteMovie> etFavouriteMovieById(@PathVariable Long id) {
        return favouriteService.findFavouriteMovie(id);
    }
}