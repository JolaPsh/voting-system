package top.graduation.rs.web.json;

import com.fasterxml.jackson.core.JsonProcessingException;

import static top.graduation.rs.web.json.JacksonObjectMapper.getMapper;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class JsonUtil {
    public static <T> String writeValue(T obj) {
        try {
            return getMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid write to JSON:\n'" + obj + "'", e);
        }
    }
}
