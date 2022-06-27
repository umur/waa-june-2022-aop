package com.example.lab3.service.impl;

import com.example.lab3.Repository.UserRepository;
import com.example.lab3.model.bidirectional.UserBi;
import com.example.lab3.service.UserBiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserBiServiceImpl implements UserBiService {
    private final UserRepository userBiRepository;

    @Override
    public void save(UserBi p) {
        userBiRepository.save(p);
    }

    @Override
    public void delete(long id) {
        userBiRepository.deleteById(id);
    }

    @Override
    public UserBi getById(long id) {
        return userBiRepository.findById(id).get();
    }

    @Override
    public List<UserBi> getAll() {
        return userBiRepository.findAll();

    }
}
