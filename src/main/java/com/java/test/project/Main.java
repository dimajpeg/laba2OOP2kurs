package com.java.test.project;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;
import com.java.test.project.services.UserService;
import com.java.test.project.services.UserServiceImpl;
import com.java.test.project.utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Create new user
        User user = new User("John Doe", 30);

        // Create cars and assign them to the user
        Auto auto1 = new Auto("Toyota", "Red");
        Auto auto2 = new Auto("Honda", "Blue");

        user.getAutos().add(auto1);
        user.getAutos().add(auto2);

        auto1.setUser(user);
        auto2.setUser(user);

        // Save user to the database
        userService.saveUser(user);

        // Retrieve user from the database by ID
        User retrievedUser = userService.findUserById(user.getId());

        // Print user information and their cars
        System.out.println("User: " + retrievedUser.getName() + ", Age: " + retrievedUser.getAge());
        for (Auto auto : retrievedUser.getAutos()) {
            System.out.println("Auto: " + auto.getModel() + ", Color: " + auto.getColor());
        }

        // Close Hibernate session
        HibernateSessionFactoryUtil.getSessionFactory().close();
    }
}
