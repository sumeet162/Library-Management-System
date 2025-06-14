package ABD.Learnovate.LibraryManagementSystem;
import java.util.*;
import ABD.Learnovate.LibraryManagementSystem.model.*;
import ABD.Learnovate.LibraryManagementSystem.Manager.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManager login = new LoginManager();
        User currenUser = null;
        while(currenUser==null){
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.println("Username: ");
                String username=sc.next();
                System.out.println("Password: ");
                String password=sc.next();
                currenUser=login.Login(username,password,library.getAllUsers());
                if (currenUser==null){
                    System.out.println("Invalid username or password,Try again.");

                }
            }else if (choice==2){
                System.out.println("Name: ");
                String name=sc.next();
                System.out.println("Username: ");
                String username=sc.next();
                System.out.println("Password: ");
                String password=sc.next();
                int userId=1000+new Random().nextInt(9000);
                User newUser=new User(userId,name,username,password,false);
                library.addUser(newUser);
                System.out.println("User registered successfully.");
            } else if (choice==3) {
                System.out.println("Goodbye!");
                return;
            }else{
                System.out.println("Invalid choice,Try again.");
            }
        }
        System.out.println("Welcome "+currenUser.getName());
        System.out.println("===MENU===");
        do {
            if (currenUser.isAdmin()){
                System.out.println("1.Add Book");
                System.out.println("2.View Book");
                System.out.println("3.View User");
                System.out.println("4.Logout");
                int choice=sc.nextInt();
                if(choice==1){
                    System.out.println("Book Title: ");
                    String title=sc.nextLine();
                    System.out.println("Book Author: ");
                    String author=sc.nextLine();
                    System.out.println("Book Publisher: ");
                    String publisher= sc.nextLine();
                    System.out.println("Book Year: ");
                    int year=sc.nextInt();
                    System.out.println("Copies: ");
                    int copies=sc.nextInt();
                    int bookId=1000+new Random().nextInt(9000);
                    Book newBook=new Book(bookId,title,author,publisher,year,copies);
                    library.addBook(newBook);
                    System.out.println();
                    System.out.println("Book Added Successfully.");
                }else if (choice==2){
                    System.out.println("===Book List===");
                    library.viewAllBooks();
                } else if (choice==3) {
                    System.out.println("===User List===");
                    ArrayList<User> users=library.getAllUsers();
                    for (User u:users){
                        String role;
                        if (u.isAdmin()){
                            role="Admin";
                        }else {
                            role="User";
                        }
                        System.out.println(u.getUserId()+": "+u.getName()+" | Role: "+u.isAdmin());
                    }
                } else if (choice==4) {
                    System.out.println("Goodbye!");
                    return;
                }else {
                    System.out.println("Invalid choice,Try again");
                }
            }else {
                System.out.println("1.View Book");
                System.out.println("2.Search Book");
                System.out.println("3.Borrow Book");
                System.out.println("4.Return Book");
                System.out.println("5. My Borrowed Books");
                System.out.println("6.Logout");
                int choice=sc.nextInt();
                if(choice==1){
                    System.out.println("===Book List===");
                    library.viewAllBooks();
                } else if (choice==2) {
                    System.out.println("Keyword: ");
                    String keyword=sc.nextLine();
                    library.searchBookByTitle(keyword);
                } else if (choice==3) {
                    System.out.println("Book Id");
                    int bookId=sc.nextInt();
                    library.borrowBook(bookId,currenUser.getUserId());
                }else if(choice==4){
                    System.out.println("Book ID");
                    int bookId= sc.nextInt();
                    library.returnBook(bookId,currenUser.getUserId());
                } else if (choice==5) {
                    currenUser.showBorrowedBooks();
                }else if (choice==6){
                    System.out.println("===Logged Out===");
                    return;
                }else {
                    System.out.println("Invalid choice,Try again");
                }
            }
        }while (true);
    }
}
