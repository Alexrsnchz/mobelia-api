package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.exception.EmailAlreadyExistsException;
import com.alexrsnchz.mobelia.model.User;
import com.alexrsnchz.mobelia.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User store(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("That email already exists");
        }

        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        userToUpdate.setAlias(user.getAlias());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setPhone(user.getPhone());

        return userRepository.save(userToUpdate);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

}
