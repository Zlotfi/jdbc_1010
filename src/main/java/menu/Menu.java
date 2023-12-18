package menu;

import model.User;
import service.UserService;
import utility.ApplicationContext;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = ApplicationContext.getUserService();

    public Menu(){
    }

    public void publicMenu() throws SQLException {
        System.out.println("***Welcome***");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("Enter your select: ");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select){
            case 1 -> enter();
            case 2 -> register();
            case 3 -> System.out.println("Exit");
            default -> System.out.println("error");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter your firstName: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your lastName: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your userName: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = null;
        boolean flag = true;
        while (flag){
            password = scanner.nextLine();
            if (Validation.isValidPasswordWithRegex(password))
                flag = false;
            else
                System.out.println("please enter a valid password");
        }
        User user = new User(null, firstName, lastName, userName, password);
        userService.register(user);
    }

    public void enter() throws SQLException {
        System.out.println("Enter your userName: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = userService.login(userName);
        if ((user == null) && !user.getPassword().equals(password))
            System.out.println("you enter a userName and password incorrect");
        else{
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("=======================================");
                System.out.println("1- update firstName");
                System.out.println("2- delete yourself");
                System.out.println("3- Exit");
                System.out.println("enter your number: ");
                int number = scanner.nextInt();
                scanner.nextLine();
                switch (number) {
                    case 1 -> userService.changeFirstName(user.getId());
                    case 2 -> userService.delete(user.getId());
                    case 3 -> isTrue = false;
                    default -> System.out.println("ERROR");
                }
            }
        }
    }
}
