package library.service;

import java.util.List;
import library.model.Author;

public interface AuthorService {
    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    List<Author> getAllAuthors();

    void deleteAuthorById(Long id);
}
