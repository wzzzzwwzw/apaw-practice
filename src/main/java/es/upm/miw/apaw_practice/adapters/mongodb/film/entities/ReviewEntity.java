package es.upm.miw.apaw_practice.adapters.mongodb.film.entities;

import es.upm.miw.apaw_practice.domain.models.film.Review;
import org.springframework.beans.BeanUtils;

public class ReviewEntity {

    private Integer rating;
    private String comment;
    private Boolean recommendation;

    public ReviewEntity() {
    }

    public ReviewEntity(Review review) {
        BeanUtils.copyProperties(review, this);
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Review toReview() {
        Review review = new Review();
        BeanUtils.copyProperties(this, review);
        return review;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", recommendation=" + recommendation +
                '}';
    }
}
