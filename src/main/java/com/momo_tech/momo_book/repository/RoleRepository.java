package com.momo_tech.momo_book.repository;

import com.momo_tech.momo_book.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
