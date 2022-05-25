package com.revature.yolp.ui;

import com.revature.yolp.models.Restaurant;
import com.revature.yolp.models.Review;
import com.revature.yolp.models.User;
import com.revature.yolp.services.RestaurantService;
import com.revature.yolp.services.ReviewService;
import com.revature.yolp.util.annotations.Inject;

import java.util.List;
import java.util.Scanner;

public class MainMenu implements IMenu {
    @Inject
    private final User user;
    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    public MainMenu(User user, ReviewService reviewService, RestaurantService restaurantService) {
        this.user = user;
        this.reviewService = reviewService;
        this.restaurantService = restaurantService;
    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to main menu " + user.getUsername());
                System.out.println("[1] View all restaurants");
                System.out.println("[x] Sign out");

                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        viewResto();
                        break;
                    case "x":
                        break exit;
                    default:
                        System.out.println("\nInvalid input.");
                        break;
                }
            }
        }
    }

    private void viewResto() {
        Scanner scan = new Scanner(System.in);
        List<Restaurant> restaurants = restaurantService.getAllResto();

        while (true) {
            System.out.println("\nPlease select a restaurant to leave a review.");

            for (int i = 0; i < restaurants.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + restaurants.get(i).getName());
            }

            System.out.print("\nEnter: ");
            int input = scan.nextInt() - 1;

            if (input >= 0 && input < restaurants.size()) {
                Restaurant selectedResto = restaurants.get(input);

                List<Review> reviews = reviewService.getReviewByResto(selectedResto.getId());

                System.out.println("\nReviews:");
                for (Review r : reviews) {
                    System.out.println("Rating: " + r.getRating() + "\n" + r.getMsg());
                }

            } else {
                System.out.println("\nInvalid restaurant selection.");
            }
        }
    }
}
