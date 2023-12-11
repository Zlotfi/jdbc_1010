import menu.Menu;
import model.User;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        UserService userService = new UserService();
//        userService.register();
//        userService.login();
//        userService.changeFirstName();
//        userService.delete();

        Menu menu = new Menu();
        menu.publicMenu();
    }
}
