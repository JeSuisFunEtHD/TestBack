package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    public Optional<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public List<Movie> getMoviesByActor(String name) {
        return movieRepository.findByActorNameLike(name);
    }
}