package top.graduation.rs.web.user;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.graduation.rs.model.Restaurant;
import top.graduation.rs.model.Vote;
import top.graduation.rs.service.VoteService;
import top.graduation.rs.to.VoteTo;
import top.graduation.rs.web.SecurityUtil;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
	private static final Logger log = LoggerFactory.getLogger(VoteController.class);
	public static final String REST_URL = "/rest/vote";

	private static final LocalTime TIME_EXPIRED = LocalTime.of(11, 0);

	@Autowired
	private VoteService service;

	/*
	 * User vote code: 201 Created, 200 Updated, 409 Conflict
	 */
	@PostMapping(value = "/{id}")
	public ResponseEntity<Restaurant> vote(@PathVariable("id") int restaurantId) {
		int userId = SecurityUtil.authUserId();
		boolean acceptVote = LocalTime.now().isBefore(TIME_EXPIRED);
		// user can update his vote until 11 a.m
		VoteTo newVote = acceptVote ? service.createOrUpdate(userId, restaurantId)
				: service.create(userId, restaurantId);
		log.info("user with {} id voted for restaurant {}", userId, restaurantId);
		return new ResponseEntity<>(newVote.getVote().getRestaurant(),
				newVote.isCreated() ? HttpStatus.CREATED : (acceptVote ? HttpStatus.OK : HttpStatus.CONFLICT));
	}

	@GetMapping
	public Optional<Vote> getUserVoteForDate(
			@RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		int userId = SecurityUtil.authUserId();
		log.info("get vote for user with id ={}, day ={}", userId, date);
		return service.getTodayUserVote(userId, date);
	}

	@GetMapping("/history")
	public List<Vote> getVotesBetween(
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		int userId = SecurityUtil.authUserId();
		log.info("get voteHistory for user with id ={}", userId);
		return service.getVotesBetween(userId, startDate, endDate);
	}
}
