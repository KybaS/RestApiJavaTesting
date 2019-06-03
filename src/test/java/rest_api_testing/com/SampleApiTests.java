package rest_api_testing.com;

import rest_api_testing.com.components.User;
import rest_api_testing.com.controllers.UserController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleApiTests {

    private UserController userController;
    private User user = new User();
    private final String USER_KSV = "KybaS";
    private final String USER_KAV = "annadakus";

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testUserHtmlUrl() {
        user = userController.getUserByUsername(USER_KSV);
        assertTrue(user.getHtmlUrl().contains("https://github.com/" + USER_KSV));
        System.out.println(user);
    }

    @Test
    public void testUserLoginName() {
        user = userController.getUserByUsername(USER_KAV);
        assertTrue(user.getLogin().contains(USER_KAV));
    }

    @Test
    public void testFollowers() {
        User[] followers = userController.getFollowersByUserName(USER_KSV);
        assertEquals(3, followers.length);
    }

    @Test
    public void testIdByUsername() {
        user = userController.getIdByUsername(USER_KAV);
        assertEquals(23164881, (int) user.getId());
    }

    @Test
    public void testBioByUsername() {
        user = userController.getBioByUsername(USER_KSV);
        assertTrue(user.getBio().contains("Everybody in this country should learn to program a computer, because it teaches you how to think"));
    }
}
