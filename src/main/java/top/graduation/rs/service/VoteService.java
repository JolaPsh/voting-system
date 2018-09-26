package top.graduation.rs.service;

import top.graduation.rs.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface VoteService {

    Optional<Vote> getTodayUserVote(int userId, LocalDate localDate);

    Vote create(int userId, int restaurantId);

    Vote update(int userId, int restaurantId);

    List<Vote> getUserVoteHistory(Integer userId);
}
