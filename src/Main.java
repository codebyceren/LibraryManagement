import java.util.Scanner;

public class Main {

    public static void showMainMenu() {
        System.out.println("================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Book Management");
        System.out.println("2. Member Management");
        System.out.println("3. Borrowing Operations");
        System.out.println("4. Exit");
    }

    public static void showBookMenu() {
        System.out.println("------ Book Management ------");
        System.out.println("1. List all books");
        System.out.println("2. Add a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Back to main menu");
    }

    public static void showMemberMenu() {
        System.out.println("------ Member Management ------");
        System.out.println("1. List all members");
        System.out.println("2. Add a member");
        System.out.println("3. Search for a member");
        System.out.println("4. Back to main menu");
    }

    public static void showBorrowingMenu() {
        System.out.println("------ Borrowing Operations ------");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Back to main menu");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {

            showMainMenu();

            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {

                case 1:
                    showBookMenu();

                    System.out.print("Enter your choice: ");
                    int bookChoice = scanner.nextInt();

                    switch (bookChoice) {

                        case 1:
                            for (Book book : library.books) {
                                System.out.println(book.id + " - " + book.title);
                            }
                            break;

                        case 2:
                            System.out.println("Please enter the book id:");
                            String bookId = scanner.next();

                            System.out.println("Please enter the book title:");
                            String bookTitle = scanner.next();

                            Book newBook = new Book(bookId, bookTitle);
                            library.books.add(newBook);

                            System.out.println("Book added successfully.");
                            break;

                        case 3:
                            System.out.println("Please enter the book id:");
                            String bookId1 = scanner.next();

                            boolean bookFound = false;

                            for (Book book : library.books) {
                                if (book.id.equals(bookId1)) {
                                    bookFound = true;
                                    System.out.println("Book found: " + book.id + " - " + book.title);
                                }
                            }

                            if (!bookFound) {
                                System.out.println("Book not found.");
                            }
                            break;

                        case 4:
                            System.out.println("Back to main menu.");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;

                case 2:
                    showMemberMenu();

                    System.out.print("Enter your choice: ");
                    int memberChoice = scanner.nextInt();

                    switch (memberChoice) {

                        case 1:
                            for (Member member : library.members) {
                                System.out.println(member.id + " - " + member.title);
                            }
                            break;

                        case 2:
                            System.out.println("Please enter the member id:");
                            String memberId = scanner.next();

                            System.out.println("Please enter the member title:");
                            String memberTitle = scanner.next();

                            Member newMember = new Member();
                            newMember.id = memberId;
                            newMember.title = memberTitle;

                            library.members.add(newMember);

                            System.out.println("Member added successfully.");
                            break;

                        case 3:
                            System.out.println("Please enter the member id:");
                            String memberId1 = scanner.next();

                            boolean memberFound = false;

                            for (Member member : library.members) {
                                if (member.id.equals(memberId1)) {
                                    memberFound = true;
                                    System.out.println("Member found: " + member.id + " - " + member.title);
                                }
                            }

                            if (!memberFound) {
                                System.out.println("Member not found.");
                            }
                            break;

                        case 4:
                            System.out.println("Back to main menu.");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;

                case 3:
                    showBorrowingMenu();

                    System.out.print("Enter your choice: ");
                    int borrowingChoice = scanner.nextInt();

                    switch (borrowingChoice) {

                        case 1:
                            System.out.println("Please enter the book id:");
                            String borrowingBookId = scanner.next();

                            System.out.println("Please enter the member id:");
                            String borrowingMemberId = scanner.next();

                            library.giveBook(borrowingBookId, borrowingMemberId);

                            System.out.println("Book borrowed successfully.");
                            break;
                        case 2 :
                            System.out.println("Please enter the book id:");
                            String returnBookId = scanner.next();


                            System.out.println("Please enter the member id:");
                            String returnMemberId = scanner.next();

                            library.receiveBook(returnBookId, returnMemberId);
                            System.out.println("Book returned successfully.");
                            break;
                        case 3:
                            System.out.println("Back to main menu.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;

                case 4:
                    
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}