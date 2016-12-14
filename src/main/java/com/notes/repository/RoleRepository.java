package com.notes.repository;

import com.notes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data Repository.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Find role by name
     * @param userRole Role name
     * @return Role
     */
    Role findByName(String userRole);
}
