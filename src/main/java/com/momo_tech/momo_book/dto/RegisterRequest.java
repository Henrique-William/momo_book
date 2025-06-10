package com.momo_tech.momo_book.dto;

public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String phoneNumber;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isValid() {
        return name != null && !name.isEmpty() &&
                email != null && !email.isEmpty() &&
                password != null && !password.isEmpty() &&
                confirmPassword != null && !confirmPassword.isEmpty() &&
                role != null && !role.isEmpty() &&
                phoneNumber != null && !phoneNumber.isEmpty();
    }

    public boolean isPasswordMatch() {
        return password != null && password.equals(confirmPassword);
    }
    public boolean isEmailValid() {
        return email != null && email.contains("@") && email.contains(".");
    }
    public boolean isPhoneNumberValid() {
        return phoneNumber != null && phoneNumber.matches("\\d{11}");
    }
    public boolean isRoleValid() {
        return role != null && (role.equalsIgnoreCase("client") || role.equalsIgnoreCase("admin"));
    }
    public boolean isRegistrationValid() {
        return isValid() && isPasswordMatch() && isEmailValid() && isPhoneNumberValid() && isRoleValid();
    }

}
