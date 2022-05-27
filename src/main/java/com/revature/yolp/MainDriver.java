package com.revature.yolp;

import com.revature.yolp.daos.UserDAO;
import com.revature.yolp.services.UserService;
import com.revature.yolp.ui.IMenu;
import com.revature.yolp.ui.StartMenu;

/* This class purpose is to start our application. */
public class MainDriver {
    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        UserService userService = new UserService(userDAO);

        /* anonymous function. */
        /* This anonymous function will disappear after the start method is done executing. */
        new StartMenu(new UserService(new UserDAO())).start();
    }
}
