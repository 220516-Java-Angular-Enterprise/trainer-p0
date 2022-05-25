package com.revature.yolp.services;

import com.revature.yolp.daos.RestaurantDAO;
import com.revature.yolp.models.Restaurant;

import java.util.List;

public class RestaurantService {
    private final RestaurantDAO restaurantDAO;

    public RestaurantService(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    public void register(Restaurant resto) {
        restaurantDAO.save(resto);
    }

    public List<Restaurant> getAllResto() {
        return restaurantDAO.getAll();
    }
}
