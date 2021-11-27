package com.example.springbootcloud.service;

import com.example.springbootcloud.converter.UserConverter;
import com.example.springbootcloud.entity.User;
import com.example.springbootcloud.model.dto.UserDto;
import com.example.springbootcloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userConverter.toEntity(userDto);
        user = userRepository.save(user);
        return userConverter.toDTO(user);
    }
    @Override
    public Iterable<User> getListUser() {
        Iterable<User> user = userRepository.findAll();
        return user;
    }

//    private static ArrayList<User> users = new ArrayList<User>();
//
//    static {
//        users.add(new User(1, "KR", 12, "kr@gmail.com", "0123120", "jump"));
//        users.add(new User(2, "KR", 12, "kr@gmail.com", "0123120", "jump"));
//        users.add(new User(3, "KR", 12, "kr@gmail.com", "0123120", "jump"));
//    }
//
//    @Override
//    public List<User> getListUser() {
//        return users;
//    }
//
//    @Override
//    public User getUserById(int id) {
//        User result = new User();
//        for (User user : users) {
//            if (id == user.getId())
//                 result = user;
//        }
//        return  result;
//    }
//
//    @Override
//    public User createUser(CreateUser req) {
//        User user = UserMapper.toUser(req);
//        user.setId(users.size()+1);
//        users.add(user);
//        return user;
//    }
//
//    @Override
//    public void updateUserById(User user) {
//        User result = new User();
//        for (User userOld : users) {
//            if (user.getId() == userOld.getId())
//            {
//                userOld.setFullname(user.getFullname());
//                userOld.setAge(user.getAge());
//                userOld.setEmail(user.getEmail());
//                userOld.setPhone(user.getPhone());
//                userOld.setActions(user.getActions());
//            }
//        }
//    }
//
//    @Override
//    public void deleteUserById(int id) {
//        users.remove(id);
//    }
}
