package at.antonio.moviecatalog.service;

import at.antonio.moviecatalog.model.Rating;
import at.antonio.moviecatalog.model.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRatingService {
  @Autowired private RestTemplate restTemplate;

  @CircuitBreaker(name = "getUserRatingCB", fallbackMethod = "getUserRatingFallback")
  UserRating getUserRating(String userId) {
    UserRating userRating =
        restTemplate.getForObject(
            "http://ratings-data-service/api/v1/ratings/user/" + userId, UserRating.class);
    return userRating;
  }

  public UserRating getUserRatingFallback(String userId, Exception e) {
    return new UserRating(userId, Arrays.asList(new Rating("0", 0)));
  }
}
