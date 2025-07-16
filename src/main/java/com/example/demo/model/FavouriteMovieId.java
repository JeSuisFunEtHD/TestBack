package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class FavouriteMovieId implements Serializable {
    private Long userId;
    private Long movieId;

    public FavouriteMovieId() {}

    public FavouriteMovieId(Long userId, Long movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavouriteMovieId)) return false;
        FavouriteMovieId that = (FavouriteMovieId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }
}