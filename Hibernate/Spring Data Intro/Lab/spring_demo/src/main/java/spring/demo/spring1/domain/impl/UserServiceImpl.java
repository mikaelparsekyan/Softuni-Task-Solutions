package spring.demo.spring1.domain.impl;

import org.springframework.stereotype.Service;
import spring.demo.spring1.dao.UserRepository;
import spring.demo.spring1.domain.UserService;
import spring.demo.spring1.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
