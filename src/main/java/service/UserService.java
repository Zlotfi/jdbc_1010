package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

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

    public void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your userName: ");
        String userName = scanner.nextLine();

        System.out.println("please enter your password: ");
        String password = scanner.nextLine();

        User user = userRepository.login(userName);
        if ((user != null) && user.getPassword().equals(password))
            System.out.println("login successfully");
        else
            System.out.println("bad credentials");
    }
}
