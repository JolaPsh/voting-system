package top.graduation.rs.to;

import java.util.Date;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class VoteHistory {
    private int voteId;
    private Date date;
    private String restaurantTitle;
    private String dishName;

    public VoteHistory(int voteId, Date date, String restaurantTitle, String dishName) {
        this.voteId = voteId;
        this.date = date;
        this.restaurantTitle = restaurantTitle;
        this.dishName = dishName;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
