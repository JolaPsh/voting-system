package top.graduation.rs.to;

import top.graduation.rs.model.Restaurant;
import top.graduation.rs.model.User;
import top.graduation.rs.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class VoteHistory {
    private int voteId;
    private String userEmail;
    private String restaurantTitle;
    private LocalDate localDate;

    public VoteHistory(int voteId, String userEmail, String restaurant, LocalDate localDate) {
        this.voteId = voteId;
        this.userEmail = userEmail;
        this.restaurantTitle = restaurant;
        this.localDate = localDate;
    }

    public VoteHistory(Vote vote) {
        this.voteId = vote.getId();
        this.userEmail = vote.getUser().getEmail();
        this.restaurantTitle = vote.getRestaurant().getTitle();
        this.localDate = vote.getDate();
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "VoteInfo{" +
                "voteId=" + voteId +
                ", userEmail='" + userEmail + '\'' +
                ", restaurantTitle='" + restaurantTitle + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}