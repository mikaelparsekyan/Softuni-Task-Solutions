package spring.demo.spring1.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.spring1.dao.UserRepository;
import spring.demo.spring1.domain.UserService;
import spring.demo.spring1.model.User;

import javax.transaction.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
