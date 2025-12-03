package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        if ((text == null || text.isEmpty()) && rating == null) {
            return listAll();
        }
        return this.bookRepository.findAllByTitleAndAverageRating(text, rating);
    }

//    @Override
//    public Book saveBook(String title, String genre, Double averageRating, Long authorId) {
//        return this.bookRepository.save(new Book(title, genre, averageRating, authorRepository.findById(authorId).orElse(null)));
//    }

    @Override
    public void editBook(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElse(null);
        assert book != null;
        book.setTitle(updatedBook.getTitle());
        book.setGenre(updatedBook.getGenre());
        book.setAverageRating(updatedBook.getAverageRating());
        book.setAuthor(updatedBook.getAuthor());

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }

    @Override
    public Book findById(Long bookId) {
        return this.bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void  saveBook(Book book) {
        this.bookRepository.save(book);
    }

}
