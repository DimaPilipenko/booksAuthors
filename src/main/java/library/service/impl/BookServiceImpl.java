package library.service.impl;

import java.util.List;
import library.model.Author;
import library.model.Book;
import library.repository.BookRepository;
import library.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get book by id " + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooksByAuthorId(Author author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> findAllByAuthorName(String authorName) {
        return bookRepository.findAllByAuthor_AuthorName(authorName);
    }

    @Override
    public Book getBookByMaxSoldAmountByAuthorName(String authorName) {
        return bookRepository.getBookByMaxSoldAmount(authorName);
    }

    @Override
    public Book getBookPublishedAmountByAuthorName(String authorName) {
        return bookRepository.getBookPublishedAmount(authorName);
    }

    @Override
    public List<Book> getAllBooksSuccessRateOfAuthor(String authorName) {
        return bookRepository.getAllBooksSuccessRateOfAuthor(authorName);
    }
}
