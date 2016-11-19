package com.moviematch;

import com.moviematch.persistence.pks.ViewerKey;
import com.moviematch.persistence.pojos.Genre;
import com.moviematch.persistence.pojos.Recommendation;
import com.moviematch.persistence.pojos.Viewer;
import com.moviematch.persistence.repositories.GenreRepository;
import com.moviematch.persistence.repositories.RecommendationRepository;
import com.moviematch.persistence.repositories.ViewerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public CommandLineRunner init(RecommendationRepository recRepository,
                                  ViewerRepository viewerRepository,
                                  GenreRepository genreRepository)
    {
        return args -> {
            final Recommendation entity = new Recommendation();
            recRepository.save(entity);
            final Viewer viewer = new Viewer();
            viewer.setViewerKey(new ViewerKey(entity.getRecId(), 1));
            viewerRepository.save(viewer);
            genreRepository.save(new Genre());
            System.out.println(recRepository.findAll());
            System.out.println(viewerRepository.findAll());
            System.out.println(genreRepository.findAll());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

