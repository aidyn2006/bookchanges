import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistrationService extends User{
     Scanner scanner=new Scanner(System.in);

    public UserRegistrationService(String name, String surname, String login, String password, String email) {
        super(name, surname, login, password, email);
    }

    public UserRegistrationService() {

    }
    @Override
    public void register() {
        System.out.println("Enter your Name: ");
        String setname= scanner.nextLine();
        super.setName(setname);
        System.out.println("Enter your Surname: ");
        String setsurname= scanner.nextLine();
        super.setSurname(setsurname);
        System.out.println("Enter your Login: ");
        String setlogin= scanner.nextLine();
        super.setLogin(setlogin);
        System.out.println("Enter your Password: ");
        String setpassword= scanner.nextLine();
        super.setPassword(setpassword);
        System.out.println("Enter your Email: ");
        String setemail= scanner.nextLine();
        super.setEmail(setemail);
        System.out.println("Succesfully registred");
        try {
            DatabaseManager.registertoplatform(setname, setsurname, setlogin, setpassword, setemail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void login(){
        System.out.println("Enter the login: ");
        String login= scanner.nextLine();
        System.out.println("Enter the password: ");
        String password= scanner.nextLine();
        try {
            if (DatabaseManager.login(login, password)) {
                System.out.println("You are login succesfully");
            } else {
                System.out.println("Something went wrong!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
