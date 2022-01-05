package com.example.quan_lyban_hang_angular.dto.request;

public class ChangeAvatar {
    private String avatar;

    public ChangeAvatar() {
    }

    public ChangeAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
