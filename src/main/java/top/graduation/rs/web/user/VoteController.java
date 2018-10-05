package top.graduation.rs.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.model.Vote;
import top.graduation.rs.service.VoteService;
import top.graduation.rs.web.SecurityUtil;
import top.graduation.rs.web.admin.RestaurantAdminController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    private static final Logger log = LoggerFactory.getLogger(RestaurantAdminController.class);
    public static final String REST_URL = "/rest/profile/vote";

    private static final LocalTime TIME_EXPIRED = LocalTime.of(11, 0);

    @Autowired
    private VoteService service;

    /*
     *  User vote code: 201 Created, 200 Updated, 409 Conflict
     */
    @PostMapping(value = "/{id}")
    public ResponseEntity<Restaurant> vote(@PathVariable("id") Integer restaurantId) {
        int userId = SecurityUtil.authUserId();
        boolean acceptVote = LocalTime.now().isBefore(TIME_EXPIRED);
        boolean isVoted = service.getTodayUserVote(userId, LocalDate.now()).isPresent();
        Vote newVote = acceptVote ? (isVoted ? service.update(userId, restaurantId)
                : service.create(userId, restaurantId)) : service.create(userId, restaurantId);
        log.info("user with {} id voted for restaurant {}", userId, restaurantId);
        return new ResponseEntity<>(newVote.getRestaurant(),
                isVoted ? (acceptVote ? HttpStatus.OK : HttpStatus.CONFLICT) : HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vote>> getUserVoteHistory(@PathVariable("id") int id) {
        int userId = SecurityUtil.authUserId();
        log.info("vote history for user with id {}", userId);
            // Another user doesn't have permission to access your vote history
        return new ResponseEntity<>(service.getUserVoteHistory(userId),
                userId != id? HttpStatus.FORBIDDEN :HttpStatus.OK);
    }
}
