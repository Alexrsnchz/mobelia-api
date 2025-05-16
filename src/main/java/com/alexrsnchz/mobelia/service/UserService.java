package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.exception.ResourceNotFoundException;
import com.alexrsnchz.mobelia.model.User;
import com.alexrsnchz.mobelia.repository.UserRepository;
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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user, Long id) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userToUpdate.setAlias(user.getAlias());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setPhone(user.getPhone());

        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

}
