package medstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    public void saveUser(UserModel user) {
        userRepo.save(user);
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public UserModel getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
