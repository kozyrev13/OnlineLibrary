package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.dao.RoleDAO;
import net.kozyrev.onlinelibrary.dao.UserDAO;
import net.kozyrev.onlinelibrary.model.Role;
import net.kozyrev.onlinelibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);

    }

    @Override
    public User findByUsername(String username) {return userDAO.findByUsername(username);
    }
}
