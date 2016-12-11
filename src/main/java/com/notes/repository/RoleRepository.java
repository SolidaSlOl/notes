package com.notes.repository;

import com.notes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String userRole);
}
