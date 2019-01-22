package top.graduation.rs.to;

import java.util.Date;
import java.util.List;
import java.util.Set;

import top.graduation.rs.model.Dish;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class VoteHistory {
    private int voteId;
    private Date date;
    private String restaurantTitle;

    public VoteHistory(int voteId, Date date, String restaurantTitle) {
        this.voteId = voteId;
        this.date = date;
        this.restaurantTitle = restaurantTitle;
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
   
	@Override
    public String toString() {
        return "VoteHistory{" +
                "voteId=" + voteId +
                ", date=" + date +
                ", restaurantTitle='" + restaurantTitle + '\'' +
                '}';
    }
}
