package at.antonio.moviecatalog.service;

import at.antonio.moviecatalog.model.CatalogItem;
import at.antonio.moviecatalog.model.Movie;
import at.antonio.moviecatalog.model.Rating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

  @Autowired private RestTemplate restTemplate;

  /*
  @Autowired
  private WebClient.Builder webclientBuilder;
   */

  @CircuitBreaker(name = "getCatalogItemCB", fallbackMethod = "getCatalogItemFallback")
  CatalogItem getCatalogItem(Rating rating) {
    Movie m =
        restTemplate.getForObject(
            "http://movie-info-service/api/v1/movie/" + rating.getMovieId(), Movie.class);
    return new CatalogItem(m.getName(), "Desc", rating.getRating());

    /* NEWER WEBCLIENT WAY
        Movie m = webclientBuilder.build()
                  .get()
                  .uri("movie-info-service/api/v1/movie/"+rating.getMovieId())
                  .retrieve()
                  .bodyToMono(Movie.class)
                   .block();
    */
  }

  private CatalogItem getCatalogItemFallback(Rating rating, Exception e) {
    return new CatalogItem("Movie name not found", "", rating.getRating());
  }
}
