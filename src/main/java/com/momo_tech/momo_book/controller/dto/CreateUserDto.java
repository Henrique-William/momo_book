package com.momo_tech.momo_book.controller.dto;

public record CreateUserDto(String name, String email, String password, String confirmPassword, String phoneNumber) {
}
