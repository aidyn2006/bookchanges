import java.sql.SQLException;
import java.util.Scanner;

public class Exchange extends Book {

    Scanner scanner=new Scanner(System.in);
    public Exchange(String name, String author, String ISBN) {
        super(name, author, ISBN);
    }

    public Exchange() {
    }

    public void addbooktoprofile(){
        System.out.println("Enter the book name: ");
        String setbookname=scanner.nextLine();
        System.out.println("Enter the book author: ");
        String setbookauthor= scanner.nextLine();
        System.out.println("Enter the ISBN of book: ");
        String setisbn= scanner.nextLine();
        try{
            DatabaseManager.addBook(setbookname,setbookauthor,setisbn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletebookfromprofile(){
        System.out.println("Enter the book isbn to delete: ");
        String isbn=scanner.nextLine();
        try{
            DatabaseManager.deleteBook(isbn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
