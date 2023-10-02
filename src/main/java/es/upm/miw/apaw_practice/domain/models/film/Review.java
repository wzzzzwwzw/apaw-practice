package es.upm.miw.apaw_practice.domain.models.film;

public class Review {

    private Integer rating;
    private String comment;
    private Boolean recommendation;

    public Review() {}

    public Review(Integer rating, String comment, Boolean recommendation) {
        this.rating = rating;
        this.comment = comment;
        this.recommendation = recommendation;
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

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", recommendation=" + recommendation +
                '}';
    }
}
