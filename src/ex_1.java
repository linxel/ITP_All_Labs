import java.util.ArrayList;
import java.util.List;

interface Media {
    String getTitle();

    String getType();
}

class Book implements Media {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "Book";
    }

    public String getAuthor() {
        return author;
    }
}

class Video implements Media {
    private String title;
    private String director;

    public Video(String title, String director) {
        this.title = title;
        this.director = director;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "Video";
    }

    public String getDirector() {
        return director;
    }
}

class Newspaper implements Media {
    private String title;
    private String publisher;

    public Newspaper(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    public String getPublisher() {
        return publisher;
    }
}

class Library<T extends Media> {
    private List<T> mediaList = new ArrayList<>();

    public void addMedia(T media) {
        mediaList.add(media);
    }

    public List<T> getMediaList() {
        return mediaList;
    }

    public List<T> getMediaByType(String type) {
        List<T> result = new ArrayList<>();
        for (T media : mediaList) {
            if (media.getType().equalsIgnoreCase(type)) {
                result.add(media);
            }
        }
        return result;
    }
}

public class ex_1 {
    public static void main(String[] args) {
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.addMedia(new Book("Asd", "F.as"));
        bookLibrary.addMedia(new Book("qd", " Ow"));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.addMedia(new Video("SDF", "Fsdf"));
        videoLibrary.addMedia(new Video("Tdsfsd", "FSDs"));

        Library<Newspaper> newspaperLibrary = new Library<>();
        newspaperLibrary.addMedia(new Newspaper("Tmes", "Thy"));
        newspaperLibrary.addMedia(new Newspaper("Tan", "Guup"));

        System.out.println("Books :");
        for (Book book : bookLibrary.getMediaList()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        System.out.println("\nVideos:");
        for (Video video : videoLibrary.getMediaList()) {
            System.out.println(video.getTitle() + " directed by " + video.getDirector());
        }

        System.out.println("\nNewspapers :");
        for (Newspaper newspaper : newspaperLibrary.getMediaList()) {
            System.out.println(newspaper.getTitle() + " published by " + newspaper.getPublisher());
        }
    }
}
