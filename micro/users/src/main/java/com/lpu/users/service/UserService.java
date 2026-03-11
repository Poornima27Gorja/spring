package com.lpu.users.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.lpu.users.entity.Users;
import com.lpu.users.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Users save(Users user) {
        return repo.save(user);
    }

    public List<Users> getAll() {
        return repo.findAll();
    }

    public Users getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}