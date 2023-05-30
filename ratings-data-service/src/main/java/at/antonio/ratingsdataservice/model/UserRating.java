package at.antonio.ratingsdataservice.model;

import java.util.List;

public class UserRating {

    public UserRating() {
    }

    public UserRating(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    private String userId;
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
