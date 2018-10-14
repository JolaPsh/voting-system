package top.graduation.rs.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.graduation.rs.service.DishService;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

@RestController
@RequestMapping(value = DishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    public static final String REST_URL = "/rest/profile/dishes";

    @Autowired
    private DishService service;

    @GetMapping("/{id}/history")
    public Object[] getDishHistory(@PathVariable("id") int id){
        log.info("get dish history, dish id = {}", id);
        return service.getDishHistory(id);
    }
}
