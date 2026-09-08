import java.util.ArrayList;

public class Library {
    

    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Member> members = new ArrayList<Member>();

    public void addMember(Member member) {

        this.members.add(member);
    }

    public boolean isMemberIdExist(String id) {

        boolean isExist = false;
        for(Member member: this.members) {

            if(member.id.equals(id)) {

                isExist = true;
            }
        }
        return isExist;

    }

    public boolean giveBook(String bookId, String memberId) {

        Book book = this.getBookById(bookId);

        if(book == null) {
            System.out.println("Book not found.");
            return false;
        }
        this.books.remove(book);

        Member member = this.getMemberById(memberId);

        if(member == null) {
            System.out.println("Member not found.");
            return false;
        }
        int memberIndex = this.getMemberIndex(member);
        this.members.get(memberIndex).borrowedBooks.add(book);


        return true;
    }

    public boolean receiveBook(String bookId, String memberId) {

        Member member = this.getMemberById(memberId);

        if(member == null) {
            System.out.println("Member not found.");
            return false;
        }

        Book book = this.getBorrowedBookById(bookId, memberId);

        if(book == null) {
            System.out.println("Book not found.");
            return false;
        }

        this.books.add(book);

        int memberIndex = this.getMemberIndex(member);
        this.members.get(memberIndex).borrowedBooks.remove(book);
        return true;
    }

    

    public int getMemberIndex(Member member) {

        return this.members.indexOf(member);

    }

    private Member getMemberById(String id){

        for(Member member : this.members) {

            if(member.id.equals(id)){

                return member;
            } 

        }
        return null;
    }

    private Book getBookById(String id) {

        for(Book book : this.books) {

            if(book.id.equals(id)) {
                return book;
            }
        }
        return null;
    }

    private Book getBorrowedBookById(String bookId, String memberId) {
        Member member = this.getMemberById(memberId);

        for(Book book : member.borrowedBooks) {

            if(book.id.equals(bookId)) {
                    return book;
            }
        }
        
        return null;
    }

}
