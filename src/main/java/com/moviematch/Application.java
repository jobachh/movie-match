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
            movie1.setTrailerUrl("https://www.youtube.com/embed/0XAlutSwY0I");
            movie1.setDescription("When Ethan Hunt, the leader of a crack espionage team whose perilous operation has gone awry with no explanation, discovers that a mole has penetrated the CIA, he's surprised to learn that he's the No. 1 suspect. To clear his name, Hunt now must ferret out the real double agent and, in the process, even the score.\n");
            movie1.setYear(1996);
            movie1.setRating(6.5f);
            movieRepository.save(movie2);
            Movie movie3 = new Movie("Men in Black", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_UY268_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/uCJHn-ZFH54");
            movie1.setDescription("Men in Black follows the exploits of agents Kay and Jay, members of a top-secret organization established to monitor and police alien activity on Earth. The two Men in Black find themselves in the middle of the deadly plot by an intergalactic terrorist who has arrived on Earth to assassinate two ambassadors from opposing galaxies. In order to prevent worlds from colliding, the MiB must track down the terrorist and prevent the destruction of Earth. It's just another typical day for the Men in Black.\n");
            movie1.setYear(1997);
            movie1.setRating(6.7f);
            movieRepository.save(movie3);
            Movie movie4 = new Movie("The Hobbit: An Unexpected Journey ", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTcwNTE4MTUxMl5BMl5BanBnXkFtZTcwMDIyODM4OA@@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("hhttps://www.youtube.com/embed/dFQS8IKrUHA");
            movie1.setDescription("Bilbo Baggins, a hobbit enjoying his quiet life, is swept into an epic quest by Gandalf the Grey and thirteen dwarves who seek to reclaim their mountain home from Smaug, the dragon.\n");
            movie1.setYear(2012);
            movie1.setRating(6.9f);
            movieRepository.save(movie4);
            Movie movie5 = new Movie("Fantastic Beasts and Where to Find Them", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxOTM1OTI4MV5BMl5BanBnXkFtZTgwODE5OTYxMDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie5);
            Movie movie6 = new Movie("Big Momma's House", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyMjdlYmUtNjQ1Zi00YTg3LTliNTgtZmNkOTRmYzEzYTMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie6);
            Movie movie7 = new Movie("Austin Powers: The Spy Who Shagged Me", "https://images-na.ssl-images-amazon.com/images/M/MV5BMmFkZGQxN2YtODNlYS00MzM5LTk3NjQtNTUxYmQ1YzkwMDhmXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie7);
            Movie movie8 = new Movie("Star Trek", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY5MTIxNjkxOF5BMl5BanBnXkFtZTYwNTkyOTE2._V1_UY268_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie8);
            Movie movie9 = new Movie("The Notebook", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTk3OTM5Njg5M15BMl5BanBnXkFtZTYwMzA0ODI3._V1_UX182_CR0,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie9);
            Movie movie10 = new Movie("The Godfather", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTUxOTdjMDMtMWY1MC00MjkxLTgxYTMtYTM1MjU5ZTJlNTZjXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR3,0,182,268_AL_.jpg");
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            movieRepository.save(movie10);
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            Movie movie11 = new Movie("Pulp Fiction", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTkxMTA5OTAzMl5BMl5BanBnXkFtZTgwNjA5MDc3NjE@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie11);
            movie1.setTrailerUrl("https://www.youtube.com/embed/4KfnU1VI9SE");
            movie1.setDescription("Brokeback Mountain is an Ang Lee film about two modern day cowboys who meet on a shepherding job in the summer of ’63. The two share a raw and powerful summer together that turns into a life long relationship conflicting with the lives they are supposed to live.\n");
            movie1.setYear(2005);
            movie1.setRating(7.2f);
            Movie movie12 = new Movie("Amélie", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA3MjVkMWMtYTQ4ZC00ODczLWFjYmQtMDFkZDQ2Y2M0NDVmXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg");
            movieRepository.save(movie12);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

