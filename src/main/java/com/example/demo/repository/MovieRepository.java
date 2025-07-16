package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTitle(String title);
    @Query("SELECT m FROM Movie m JOIN m.movieActors ma JOIN ma.actor a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Movie> findByActorNameLike(@Param("name") String name);
}