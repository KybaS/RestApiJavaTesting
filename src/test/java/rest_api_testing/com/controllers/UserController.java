package rest_api_testing.com.controllers;

import rest_api_testing.com.components.User;
import org.springframework.web.client.RestTemplate;

public class UserController {
    private RestTemplate restTemplate;
    private final String API_BASE = "https://api.github.com";

    public UserController() {
        restTemplate = new RestTemplate();
    }

    public User getUserByUsername(String userName) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public User[] getFollowersByUserName(String userName) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName + "/followers", User[].class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public User getIdByUsername(String userName) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public User getBioByUsername(String userName) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
