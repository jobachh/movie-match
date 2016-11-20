package com.moviematch.web;

import com.moviematch.persistence.pojos.Movie;
import com.moviematch.persistence.pojos.Recommendation;
import com.moviematch.persistence.repositories.MovieRepository;
import com.moviematch.persistence.repositories.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationApiController {

    private final RecommendationRepository recommendationRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public RecommendationApiController(RecommendationRepository recommendationRepository,
                                       MovieRepository movieRepository) {
        this.recommendationRepository = recommendationRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Iterable<Recommendation> listRecommendations() {
        return recommendationRepository.findAll();
    }

    @PostMapping
    public Recommendation createRecommendation() {
        Recommendation recommendation = new Recommendation();
        recommendationRepository.save(recommendation);
        return recommendation;
    }

    @GetMapping("{recId}")
    public Recommendation getRecommendation(@PathVariable long recId) {
        return recommendationRepository.findOne(recId);
    }

    @GetMapping("{recId}/results")
    public Iterable<Movie> getResults(@PathVariable long recId) {
        return movieRepository.findAll();
    }

}
