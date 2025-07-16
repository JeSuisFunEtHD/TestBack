package com.example.demo.service;

import com.example.demo.model.FavouriteMovie;
import com.example.demo.model.FavouriteMovieId;
import com.example.demo.model.Movie;
import com.example.demo.repository.FavouriteMovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class FavouriteService {
    private final FavouriteMovieRepository repository;

    public FavouriteService(FavouriteMovieRepository repository) {
        this.repository = repository;
    }

    public void addToFavourites(Long userId, Long movieId) {
        FavouriteMovie fav = new FavouriteMovie(userId, movieId);
        repository.save(fav);
    }
    public List<FavouriteMovie> findFavouriteMovie(long id) {
        return repository.findAllByUserId(id);
    }
}