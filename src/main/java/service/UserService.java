package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    Scanner scanner = new Scanner(System.in);

    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void register(User user) throws SQLException {
        int result = userRepository.save(user);
        if (result != 0)
            System.out.println(user.getFirstName() + " successfully added to database");
        else
            System.out.println("OOps!:(");
    }

    public User login(String userName) throws SQLException {
        User user = userRepository.login(userName);
        return user;
    }

    public void changeFirstName(int id) throws SQLException {
        System.out.println("please enter your new firstName:");
        String firstName = scanner.nextLine();
        int result = userRepository.updateFirstName(firstName,id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("OOps!:(");
    }

    public void delete(int id) throws SQLException {
        int result = userRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("OOps!:(");
    }
}
