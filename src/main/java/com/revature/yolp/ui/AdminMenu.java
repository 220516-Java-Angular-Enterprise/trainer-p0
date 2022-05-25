package com.revature.yolp.ui;

import com.revature.yolp.models.Restaurant;
import com.revature.yolp.models.User;
import com.revature.yolp.services.RestaurantService;
import com.revature.yolp.util.annotations.Inject;

import java.util.Scanner;
import java.util.UUID;

public class AdminMenu implements IMenu {
    @Inject
    private final User user;
    private final RestaurantService restaurantService;

    @Inject
    public AdminMenu(User user, RestaurantService restaurantService) {
        this.user = user;
        this.restaurantService = restaurantService;
    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\n" + drawHorizontalLine("| Welcome to admin menu  |", user.getUsername()));
                System.out.println("| Welcome to admin menu " + user.getUsername() + " |");
                System.out.println(drawHorizontalLine("| Welcome to admin menu  |", user.getUsername()));
                System.out.println("[1] Create restaurant");
                System.out.println("[2] Update restaurant");
                System.out.println("[3] Delete restaurant");
                System.out.println("[4] Search restaurant");
                System.out.println("[x] Sign out");

                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        createRestaurant();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
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

    private void createRestaurant() {
        Scanner scan = new Scanner(System.in);
        Restaurant resto = new Restaurant();

        exit:
        {
            while (true) {
                System.out.println("\nCreating restaurant...");

                resto.setId(UUID.randomUUID().toString());

                System.out.print("\nName: ");
                resto.setName(scan.nextLine());

                System.out.print("\nCity: ");
                resto.setCity(scan.nextLine());

                System.out.print("\nState: ");
                resto.setState(scan.nextLine());

                System.out.println("\nPlease confirm restaurant (y/n)");
                System.out.println("\n" + resto);

                switch (scan.nextLine()) {
                    case "y":
                        restaurantService.register(resto);
                        break exit;
                    case "n":
                        break;
                    default:
                        System.out.println("\nInvalid input.");
                        break;
                }
            }
        }
    }

    private String drawHorizontalLine(String msg, String nameLength) {
        int len = msg.length() + nameLength.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) sb.append("+");
            else sb.append("-");
        }

        return sb.toString();
    }
}
