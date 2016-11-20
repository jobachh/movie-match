package com.moviematch.web;

import com.moviematch.persistence.pks.ViewerKey;
import com.moviematch.persistence.pojos.Movie;
import com.moviematch.persistence.pojos.Viewer;
import com.moviematch.persistence.repositories.MovieRepository;
import com.moviematch.persistence.repositories.RecommendationRepository;
import com.moviematch.persistence.repositories.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations/{recId}/viewers")
public class ViewersApiController {

    private final RecommendationRepository recommendationRepository;
    private final ViewerRepository viewerRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ViewersApiController(RecommendationRepository recommendationRepository,
                                ViewerRepository viewerRepository,
                                MovieRepository movieRepository) {
        this.recommendationRepository = recommendationRepository;
        this.viewerRepository = viewerRepository;
        this.movieRepository = movieRepository;
    }

    @PostMapping
    public Viewer createViewer(@PathVariable long recId, @RequestBody Viewer viewer) {
        viewerRepository.save(viewer);
        return viewer;
    }

    @PostMapping("{viewerNumber}/likedMovies")
    public Viewer postLikedMovies(@PathVariable long recId,
                                  @PathVariable int viewerNumber,
                                  @RequestBody Movie movie) {
        Viewer viewer = viewerRepository.findOne(new ViewerKey(recId, viewerNumber));
        viewer.getMovies().add(movie);
        viewerRepository.save(viewer);
        return viewer;
    }

    @GetMapping ("{viewerNumber}/genreMovies")
    public Iterable<Movie> getGenreMovies(@PathVariable long recId,
                                     @PathVariable int viewerNumber) {
        Viewer viewer = viewerRepository.findOne(new ViewerKey(recId, viewerNumber));
        //TODO: filter movies
        return movieRepository.findAll();
    }

    @GetMapping ("{viewerNumber}/matchedMovies")
    public Iterable<Movie> getMatchedMovies(@PathVariable long recId,
                                     @PathVariable int viewerNumber) {
        Viewer viewer = viewerRepository.findOne(new ViewerKey(recId, viewerNumber));
        //TODO: filter movies
        return movieRepository.findAll();
    }
}
