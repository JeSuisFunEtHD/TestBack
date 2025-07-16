package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_actor")
@IdClass(MovieActorId.class)
public class MovieActor {

    @Id
    @Column(name = "actor_id")
    private Long actorId;

    @Id
    @Column(name = "movie_id")
    private Long movieId;
    private String role;
    // Конструкторы
    public MovieActor() {}
    public MovieActor(Long actorId, Long movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;
    // Геттеры и сеттеры
    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String role() {
        return role;
    }
    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}