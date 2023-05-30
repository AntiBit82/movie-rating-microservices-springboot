package at.antonio.ratingsdataservice.controller;

import at.antonio.ratingsdataservice.model.Rating;
import at.antonio.ratingsdataservice.model.UserRating;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsDataController {

  @GetMapping("/{movieId}")
  public Rating getRating(@PathVariable("movieId") String movieId) {
    return new Rating(movieId, 7);
  }

  @GetMapping("/user/{userId}")
  public UserRating getRatingsForUser(@PathVariable("userId") String userId) {
    return new UserRating(
        userId,
        Arrays.asList(
            new Rating("Shaun of the Dead", 9),
            new Rating("Scary Movie", 7),
            new Rating("From Dusk till Dawn", 10)));
  }
}
