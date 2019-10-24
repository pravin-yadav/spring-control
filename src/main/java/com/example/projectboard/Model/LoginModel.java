package com.example.projectboard.Model;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginModel {
    private String email;
    private String mobile;
    private String password;

    public LoginModel( String email, String mobile, String password) {
        this.email = email;
        this.mobile = mobile;
        this.password = password;
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
}
