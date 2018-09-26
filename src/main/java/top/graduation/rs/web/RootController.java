package top.graduation.rs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.graduation.rs.AuthorizedUser;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;

import java.util.List;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@RestController
@RequestMapping(value = RootController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    static final String REST_URL = "/rest/**/restaurants";

    @Autowired
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        log.info("get all restaurants {}");
        int userId = AuthorizedUser.id();
        return new ResponseEntity<>(service.getAll(userId), HttpStatus.OK);
    }
}
