package com.notes.service;

import com.notes.model.User;
import com.notes.repository.RoleRepository;
import com.notes.repository.UserRepository;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service implementation.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private SecurityService securityService;

    @Override
    @Transactional
    public void register(final User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(this.roleRepository.findAll()));
        this.userRepository.save(user);
        this.securityService.autologin(
            user.getUsername(), user.getPasswordConfirm()
        );
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findCurrentUser() {
        return this.userRepository.findByUsername(SecurityContextHolder
            .getContext().getAuthentication().getName());
    }
}
