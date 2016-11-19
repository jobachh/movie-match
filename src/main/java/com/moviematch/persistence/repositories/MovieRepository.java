package com.moviematch.persistence.repositories;

import com.moviematch.persistence.pojos.Genre;
import com.moviematch.persistence.pojos.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
