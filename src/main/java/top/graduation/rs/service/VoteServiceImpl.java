package top.graduation.rs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Vote;
import top.graduation.rs.repository.datajpa.RestaurantRepository;
import top.graduation.rs.repository.datajpa.UserRepository;
import top.graduation.rs.repository.datajpa.VoteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class VoteServiceImpl implements VoteService{
    private static final Logger log = LoggerFactory.getLogger(VoteServiceImpl.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private VoteRepository voteRepo;

    @Override
    public Optional<Vote> getTodayUserVote(int userId, LocalDate localDate) {
        log.info("get today user vote{} ", userId);
        return voteRepo.getTodayUserVote(userId, localDate);
    }

    @Transactional
    @Override
    public Vote create(int userId, int restaurantId) {
        Vote todayVote = getTodayUserVote(userId, LocalDate.now()).orElse(null);
        if (todayVote == null) {
            Vote vote = new Vote(userRepo.getOne(userId),
                    restaurantRepo.getOne(restaurantId),
                    LocalDate.now());
            log.info("create vote{} ", vote);
            return voteRepo.save(vote);
        }
        return null;
    }

    @Transactional
    @Override
    public Vote update(int userId, int restaurantId) {
        Vote todayVote = getTodayUserVote(userId, LocalDate.now()).get();
        todayVote.setRestaurant(restaurantRepo.getOne(restaurantId));
        todayVote.setUser(userRepo.findById(userId).get());
        todayVote.setDate(LocalDate.now());
        log.info("update vote{}", todayVote);
        return voteRepo.save(todayVote);
    }

    @Override
    public List<Vote> getUserVoteHistory(int userId) {
        log.info("get vote history for user with id {}", userId);
        return voteRepo.getUserVoteHistory(userId);
    }
}
