package com.moviematch.persistence.repositories;

import com.moviematch.persistence.pojos.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
