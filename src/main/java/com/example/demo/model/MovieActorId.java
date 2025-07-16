package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class MovieActorId implements Serializable {
    private Long actorId;
    private Long movieId;

    public MovieActorId() {}

    public MovieActorId(Long userId, Long movieId) {
        this.actorId = userId;
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieActorId)) return false;
        MovieActorId that = (MovieActorId) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movieId);
    }
}