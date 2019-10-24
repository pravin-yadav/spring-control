package com.example.projectboard.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RegisterModel {
    private String email;
    private String mobile;
    private String password;
    private String confirmPassword;

    public RegisterModel(String email, String mobile, String password, String confirmPassword) {
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
