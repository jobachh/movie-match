package com.moviematch.web;

import com.moviematch.persistence.pojos.Recommendation;
import com.moviematch.persistence.repositories.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationApiController {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationApiController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
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
    public String getResults(@PathVariable long recId) {
        return "Brokeback Mountain";
    }

}
