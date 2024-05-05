import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserRegistrationService user = new UserRegistrationService();
        Exchange exchange=new Exchange();
        boolean result=true;
        while (result){
            System.out.println("Choose number: ");
            System.out.println("1.Register\n" +
                    "2.Login\n" +
                    "3.Addbook\n" +
                    "4.Deletebook\n" +
                    "5.Display my books\n" +
                    "6.Find book\n" +
                    "7.I want to exchange\n" +
                    "8.Show users that want exchange\n" +
                    "9.Exit");
            int number= scanner.nextInt();
            switch (number){
                case 1 -> user.register();
                case 2 -> user.login();
                case 3 -> exchange.addbooktoprofile();
                case 4 -> exchange.deletebookfromprofile();
                case 6 -> exchange.findbook();
                case 9 -> result=false;
            }
        }





    }
}