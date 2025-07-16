package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/find")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        return movieService.getMovieByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/by-actor")
    public ResponseEntity<List<Movie>> getMoviesByActor(@RequestParam String name) {
        List<Movie> movies = movieService.getMoviesByActor(name);
        return movies.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(movies);
    }
}