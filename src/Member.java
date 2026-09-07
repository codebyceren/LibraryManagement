import java.util.ArrayList;

public class Member {
    
    public String title;
    public String id;

    public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public void receiveBook(Book book) {

        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {

        this.borrowedBooks.remove(book);
    }
}
