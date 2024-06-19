package org.example.doanki2.Model.User;

import org.example.doanki2.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getUserById(Integer id ){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        throw new IllegalArgumentException("No such user");
    }
    public Users postUser(Users user) {
        return userRepository.save(user);
    }
    public Users deleteUser(int id) {
       if(userRepository.findById(id).isPresent()){
           userRepository.deleteById(id);
       }
       return null;
    }
    public Users updateUser( Users user) {
        Optional<Users> userOptional = userRepository.findById(user.getUser_id());
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("user not found");
        }
        Users userToUpdate = userOptional.get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRole(user.getRole());

        return userRepository.save(userToUpdate);
    }
}
