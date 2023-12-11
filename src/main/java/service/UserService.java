package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void register() throws SQLException {
        User user = new User(null,"zahra","lotfi","zlotfi","1380");
        int result = userRepository.save(user);
        if (result != 0)
            System.out.println(user.getFirstName() + " successfully added to database");
        else
            System.out.println("OOps!:(");
    }
}
