package top.graduation.rs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Vote;
import top.graduation.rs.repository.datajpa.RestaurantRepository;
import top.graduation.rs.repository.datajpa.UserRepository;
import top.graduation.rs.repository.datajpa.VoteRepository;
import top.graduation.rs.to.VoteTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class VoteServiceImpl implements VoteService {
    private static final Logger log = LoggerFactory.getLogger(VoteServiceImpl.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private VoteRepository voteRepo;

    @Override
    public Optional<Vote> getTodayUserVote(int userId) {
        log.info("get today={} user vote{} ", LocalDate.now(), userId);
        return voteRepo.getTodayUserVote(userId);
    }

    @Transactional
    @Override
    public VoteTo create (int userId, int restaurantId) {
        Vote todayVote = getTodayUserVote(userId).orElse(null);
        if (todayVote!=null){
            throw  new DataIntegrityViolationException("");
        }
       Vote newVote = new Vote(userRepo.getOne(userId),
               restaurantRepo.getOne(restaurantId),
               LocalDate.now());
        VoteTo voteTo = new VoteTo(newVote, true);
        voteRepo.save(voteTo.getVote());
        log.info("create vote{} ", voteTo);
        return voteTo;
    }

    @Transactional
    @Override
    public VoteTo createOrUpdate(int userId, int restaurantId) {
        Vote newVote = new Vote(userRepo.getOne(userId),
                restaurantRepo.getOne(restaurantId),
                LocalDate.now());
        VoteTo todayVote = voteRepo.getTodayUserVote(userId)
                .map(v->  {
                    v.setRestaurant(restaurantRepo.getOne(restaurantId));
                    return new VoteTo(v, false);
                })
                .orElseGet(() -> new VoteTo(newVote, true));
        voteRepo.save(todayVote.getVote());
        log.info("update vote{}", todayVote);
        return todayVote;
    }

    @Override
    public List<Object[]> getUserVoteHistory(int userId) {
        log.info("get vote history for user with id {}", userId);
        return voteRepo.getUserVoteHistory(userId);
    }
}
