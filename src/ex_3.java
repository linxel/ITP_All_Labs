import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ex_3 {
    public static void main(String[] args) {
        ReaderLibrary readerLibrary = new ReaderLibrary();
        String serializedFilePath = "serialized.dat";

        List<Book> books = Arrays.asList(new Book("A1", "T1", 2024, 10, 23), new Book("A2", "T2", 2100, 21450, 745));

        readerLibrary.addMyReadBooks(books, serializedFilePath);
        readerLibrary.displayMyBooks(books);
        List<Book> serializedBooks = readerLibrary.getMySerializedBooks(serializedFilePath);
        readerLibrary.displayMyBooks(serializedBooks);
    }
}


class ReaderLibrary {

    public void addMyReadBooks(List<Book> books, String serializedFilePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedFilePath))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getMySerializedBooks(String serializedFilePath) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedFilePath))) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void displayMyBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}


class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String author;
    private String title;
    private int issueYear;
    private int pageNumber;
    private int bookmark;

    public Book(String author, String title, int issueYear, int pageNumber, int bookmark) {
        this.author = author;
        this.title = title;
        this.issueYear = issueYear;
        this.pageNumber = pageNumber;
        this.bookmark = bookmark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "Book{" + "author='" + author + '\'' + ", title='" + title + '\'' + ", issueYear=" + issueYear + ", pageNumber=" + pageNumber + ", bookmark=" + bookmark + '}';
    }
}
