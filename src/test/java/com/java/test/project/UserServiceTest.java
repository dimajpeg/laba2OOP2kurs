package com.java.test.project;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;
import com.java.test.project.services.UserService;
import com.java.test.project.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceTest {
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void test1() throws SQLException {
        User user = new User("Masha", 26);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.getAutos().add(ferrari);

        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.getAutos().add(ford);

        userService.updateUser(user);

        User retrievedUser = userService.findUserById(user.getId());
        assertEquals("Masha", retrievedUser.getName());
        assertEquals(2, retrievedUser.getAutos().size());
    }

    @Test
    public void test2() throws SQLException {
        User user = new User("Masha", 26);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.getAutos().add(ferrari);

        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.getAutos().add(ford);

        userService.updateUser(user);

        user.setName("Sasha");
        userService.updateUser(user);

        userService.deleteUser(user);

        User deletedUser = userService.findUserById(user.getId());
        assertNull(deletedUser);
    }
}
