package com.revature.yolp.models;

public class Review {
    private String id;
    private int rating;
    private String msg;
    private int user_id;
    private int restaurant_id;

    public Review() {

    }

    public Review(String id, int rating, String msg) {
        this.id = id;
        this.rating = rating;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", msg='" + msg + '\'' +
                '}';
    }
}
