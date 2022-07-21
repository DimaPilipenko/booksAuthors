package library.service;

import java.util.List;
import library.model.Author;
import library.model.Book;

public interface BookService {
    Book createBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBooks();

    void deleteBookById(Long id);

    List<Book> getAllBooksByAuthorId(Author author);

    List<Book> findAllByAuthorName(String authorName);

    Book getBookByMaxSoldAmountByAuthorName(String authorName);

    Book getBookPublishedAmountByAuthorName(String authorName);

    List<Book> getAllBooksSuccessRateOfAuthor(String authorName);
}
