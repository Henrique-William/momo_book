package com.momo_tech.momo_book.dto;

public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isValid() {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
    public boolean isEmailValid() {
        return email != null && email.contains("@") && email.contains(".");
    }
    public boolean isPasswordValid() {
        return password != null && !password.isEmpty();
    }
    public boolean isLoginValid() {
        return isValid() && isEmailValid() && isPasswordValid();
    }

}
