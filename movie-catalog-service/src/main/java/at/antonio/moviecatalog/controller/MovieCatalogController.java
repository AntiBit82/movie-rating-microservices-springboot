package at.antonio.moviecatalog.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import at.antonio.moviecatalog.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1/catalog")
public class MovieCatalogController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient.Builder webclientBuilder;

  @GetMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
      UserRating userRating = restTemplate.getForObject("http://ratings-data-service/api/v1/ratings/user/"+userId, UserRating.class);

      /*return userRating.getRatings().stream()
              .map(rating -> {
                  Movie m = webclientBuilder.build()
                          .get()
                          .uri("http://localhost:8082/api/v1/movie/"+rating.getMovieId())
                          .retrieve()
                          .bodyToMono(Movie.class)
                          .block();
                  return new CatalogItem(m.getName(), "Desc", rating.getRating());
              }).collect(Collectors.toList());
    */

    return userRating.getRatings().stream()
        .map(rating -> {
          Movie m = restTemplate.getForObject("http://movie-info-service/api/v1/movie/"+rating.getMovieId(), Movie.class);
          return new CatalogItem(m.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
    }

}
