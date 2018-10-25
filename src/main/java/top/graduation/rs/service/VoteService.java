package top.graduation.rs.service;

import org.springframework.security.access.annotation.Secured;
import top.graduation.rs.model.Vote;
import top.graduation.rs.to.VoteHistory;
import top.graduation.rs.to.VoteTo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface VoteService {

    Optional<Vote> getTodayUserVote(int userId);

    @Secured({"ROLE_USER"})
    VoteTo create(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    VoteTo createOrUpdate(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    List<VoteHistory> getUserVotes(int userId);
}
