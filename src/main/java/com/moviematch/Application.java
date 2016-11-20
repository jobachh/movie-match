package com.moviematch;

import com.moviematch.persistence.pks.ViewerKey;
import com.moviematch.persistence.pojos.Movie;
import com.moviematch.persistence.pojos.Recommendation;
import com.moviematch.persistence.pojos.Viewer;
import com.moviematch.persistence.repositories.GenreRepository;
import com.moviematch.persistence.repositories.MovieRepository;
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
                                  GenreRepository genreRepository,
                                  MovieRepository movieRepository)
    {
        return args -> {
            recRepository.deleteAll();
            viewerRepository.deleteAll();
            genreRepository.deleteAll();
            movieRepository.deleteAll();

            Recommendation rec = new Recommendation();
            recRepository.save(rec);
            Viewer viewer = new Viewer(new ViewerKey(rec.getRecId(), 1), "Christian");
            viewerRepository.save(viewer);
            Movie movie1 = new Movie("Brokeback Mountain", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY5NTAzNTc1NF5BMl5BanBnXkFtZTYwNDY4MDc3._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie1);
            Movie movie2 = new Movie("Mission Impossible", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3NjI2MjU0Nl5BMl5BanBnXkFtZTgwNDk3ODYxMTE@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie2);
            Movie movie3 = new Movie("Men in Black", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_UY268_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie3);
            Movie movie4 = new Movie("The Hobbit", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTcwNTE4MTUxMl5BMl5BanBnXkFtZTcwMDIyODM4OA@@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie4);
            Movie movie5 = new Movie("Fantastic Beasts and Where to Find Them", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxOTM1OTI4MV5BMl5BanBnXkFtZTgwODE5OTYxMDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie5);
            Movie movie6 = new Movie("Big Momma's House", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyMjdlYmUtNjQ1Zi00YTg3LTliNTgtZmNkOTRmYzEzYTMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie6);
            Movie movie7 = new Movie("Austin Powers: The Spy Who Shagged Me", "https://images-na.ssl-images-amazon.com/images/M/MV5BMmFkZGQxN2YtODNlYS00MzM5LTk3NjQtNTUxYmQ1YzkwMDhmXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie7);
            Movie movie8 = new Movie("Star Trek", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY5MTIxNjkxOF5BMl5BanBnXkFtZTYwNTkyOTE2._V1_UY268_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie8);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

