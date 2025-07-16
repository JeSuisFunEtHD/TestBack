package com.example.demo.repository;

import com.example.demo.model.FavouriteMovie;
import com.example.demo.model.FavouriteMovieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface FavouriteMovieRepository extends JpaRepository<FavouriteMovie, FavouriteMovieId> {
    List<FavouriteMovie> findAllByUserId(Long userId);
}