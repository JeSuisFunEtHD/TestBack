package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "favourite")
@IdClass(FavouriteMovieId.class)
public class FavouriteMovie {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "movie_id")
    private Long movieId;

    // Конструкторы
    public FavouriteMovie() {}
    public FavouriteMovie(Long userId, Long movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    // Геттеры и сеттеры
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}