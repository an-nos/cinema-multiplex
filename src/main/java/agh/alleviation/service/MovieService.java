package agh.alleviation.service;

import agh.alleviation.model.Genre;
import agh.alleviation.model.Movie;
import agh.alleviation.persistence.GenreRepository;
import agh.alleviation.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Movie service.
 *
 * @author Anna Nosek
 */
@Service
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    /**
     * Instantiates a new Movie service.
     *
     * @param movieRepository the movie repository
     * @param genreRepository the genre repository
     */
    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    /**
     * Add movie movie.
     *
     * @param name  the name
     * @param genre the genre
     * @return the movie
     */
    public Movie addMovie(String name, Genre genre) {
        Movie movie = new Movie(name, genre);
        movieRepository.save(movie);
        return movie;
    }

    /**
     * Add genre genre.
     *
     * @param name the name
     * @return the genre
     */
    public Genre addGenre(String name){
        Genre genre = new Genre(name);
        genreRepository.save(genre);
        return genre;
    }


    /**
     * Find movie movie.
     *
     * @param name the name
     * @return the movie
     */
    public Movie findMovie(String name) {
        return movieRepository.findByName(name);
    }

    /**
     * Gets all movies.
     *
     * @return the all movies
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}