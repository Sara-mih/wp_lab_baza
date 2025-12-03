package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
//import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    private final BookService bookService;
    private final AuthorService authorService;
    public static List<Book> books = new ArrayList<>();
//    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    public DataHolder(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init(){
        Author orwell = (new Author( "George", "Orwell", "UK", "Author of 1984 and Animal Farm"));
        Author rowling = (new Author("J.K.", "Rowling", "UK", "Author of the Harry Potter series"));
        Author austen = (new Author("Jane", "Austen", "UK", "Author of Pride and Prejudice"));
        authorService.save(austen);
        authorService.save(rowling);
        authorService.save(orwell);
        authors.add(orwell);
        authors.add(rowling);
        authors.add(austen);
        for (int i = 0; i < 10; i++){
            Author author = authors.get(i % authors.size());
            books.add(new Book("Pride and Prejudice "+i,"Drama",5.5,author));

            bookService.saveBook(new Book("Pride and Prejudice "+i,"Drama",5.5,author));
        }
//        reservations=new ArrayList<>();
    }
}
