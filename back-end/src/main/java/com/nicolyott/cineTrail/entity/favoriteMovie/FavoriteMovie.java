package com.nicolyott.cineTrail.entity.favoriteMovie;

import com.nicolyott.cineTrail.dto.MovieDTO;
import com.nicolyott.cineTrail.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "favorite_movies")
public class FavoriteMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idTmdb;
    private String title;

    @Column(length = 1024)
    private String overview;
    private LocalDateTime favoriteDate;
    private String poster;
    private Double voteAverage;
    private boolean isFavorite;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FavoriteMovieCategory favoriteMovieCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public FavoriteMovie(MovieDTO movieDTO, FavoriteMovieCategory favoriteMovieCategory, User user){
        this.idTmdb = movieDTO.idTmdb();
        this.title = movieDTO.name();
        this.overview = movieDTO.overview();
        this.favoriteDate = LocalDateTime.now();
        this.poster = movieDTO.poster();
        this.voteAverage = movieDTO.voteAverage();
        this.isFavorite = true;
        this.favoriteMovieCategory = favoriteMovieCategory;
        this.user = user;
    }
}
