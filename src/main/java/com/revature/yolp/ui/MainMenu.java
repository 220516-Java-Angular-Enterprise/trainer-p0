package com.revature.yolp.ui;

import com.revature.yolp.models.User;
import com.revature.yolp.util.annotations.Inject;

public class MainMenu implements IMenu {
    @Inject
    private final User user;

    @Inject
    public MainMenu(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        System.out.println("\nWelcome to the main menu " + user.getUsername());
    }
}
