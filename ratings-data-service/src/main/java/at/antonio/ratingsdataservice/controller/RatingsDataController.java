package at.antonio.ratingsdataservice.controller;

import at.antonio.shared.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsDataController {

    @GetMapping("/{movieId}")
    public Rating getRatimg(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 7);
    }
}
