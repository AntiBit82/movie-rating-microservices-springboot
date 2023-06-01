package at.antonio.moviecatalog.service;

import at.antonio.moviecatalog.model.CatalogItem;
import at.antonio.moviecatalog.model.UserRating;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MovieCatalogService {
  private final MovieInfoService movieInfoService;
  private final UserRatingService userRatingService;

  public MovieCatalogService(
      MovieInfoService movieInfoService, UserRatingService userRatingService) {
    this.movieInfoService = movieInfoService;
    this.userRatingService = userRatingService;
  }

  public List<CatalogItem> getCatalog(String userId) {
    UserRating userRating = userRatingService.getUserRating(userId);
    return userRating.getRatings().stream()
        .map(rating -> movieInfoService.getCatalogItem(rating))
        .collect(Collectors.toList());
  }
}
