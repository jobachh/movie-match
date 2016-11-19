package com.moviematch.persistence.repositories;

import com.moviematch.persistence.pojos.Recommendation;
import org.springframework.data.repository.CrudRepository;

public interface RecommendationRepository extends CrudRepository<Recommendation, Long> {

}
