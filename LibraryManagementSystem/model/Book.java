package ABD.Learnovate.LibraryManagementSystem.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int copies;
    private int totalcopies;

    public Book(int id, String title, String author, String publisher, int copies, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalcopies=totalcopies;
        this.copies=totalcopies;
    }
    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getCopies() {
        return copies;
    }

    public int getTotalcopies() {
        return totalcopies;
    }
    public void increasecopies(){
        this.copies+=1;
    }
    public void decreasecopies(){
        this.copies-=1;
    }
    public String fullDetails(){
        return "Book ID: "+id+" | Title: "+title+" | Author: "+author+
                " | Publisher: "+publisher+" | Year: "+year+" | Copies: "+copies+"/"+totalcopies;
    }
}
