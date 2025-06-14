package ABD.Learnovate.LibraryManagementSystem.Manager;
import ABD.Learnovate.LibraryManagementSystem.model.*;
import java.util.*;
public class LibraryManager {
    private ArrayList<Book> books=new ArrayList<>();
    private ArrayList<User> users=new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public void addUser(User user){
        users.add(user);
    }
    public Book getBookbyId(int id){
        for (Book b:books){
            if (b.getId()==id){
                return b;
            }
        }
        return null;
    }
    public User getUserbyId(int id){
        for (User u:users){
            if(u.getUserId()==id){
                return u;
            }
        }
        return null;
    }
    public void viewAllBooks(){
            for (Book b:books){
                System.out.println(b);
            }
        }
//    public void viewAllUsers() {
//        if (users.isEmpty() == true) {
//            System.out.println("No books in library.");
//        } else {
//            for (User b : users) {
//                System.out.println(b.getName());
//            }
//        }
//    }
    public ArrayList<User> getAllUsers(){
        return users;
    }
    public void searchBookByTitle(String title){
        String keyword=title.toLowerCase();
        boolean found=false;
        for (Book b: books){
            String  bTitle=b.getTitle().toLowerCase();
            if(bTitle.contains(keyword)){
                System.out.println(b);
                found=true;
            }
        }
        if (found==false){
            System.out.println("Book not found.");
        }
    }
    public void borrowBook(int bookId,int userId){
        Book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(u!=null && b!=null && b.getCopies()>0){
            b.decreasecopies();
            u.borrowBooks(bookId);
            System.out.println("Book borrowed successfully.");
        }
        else {
            System.out.println("Book not found or user not found");
        }
    }
    public void returnBook(int bookId,int userId){
        Book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(b!=null && u!=null){
            b.increasecopies();
            u.returnBooks(bookId);
            System.out.println("book returned successfully");
        }else {
            System.out.println("Unable to return book");
        }
    }
}
