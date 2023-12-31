package app.braylees.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    public List<Movie> allMovies(){

        return repository.findAll();
    }

    public Optional<Movie> oneMovie(String imdbId) {

        return repository.getMovieByImdbId(imdbId);
    }
}
