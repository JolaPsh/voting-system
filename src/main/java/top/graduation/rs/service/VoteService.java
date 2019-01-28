package top.graduation.rs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;

import top.graduation.rs.model.Vote;
import top.graduation.rs.to.VoteTo;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface VoteService {

    Optional<Vote> getTodayUserVote(int userId, Date date);

    @Secured({"ROLE_USER"})
    VoteTo create(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    VoteTo createOrUpdate(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    List<Vote> getVotesBetween(int userId, Date startDate, Date endDate);
}
