package library.mapper;

import library.dto.BookRequestDto;
import library.dto.BookResponseDto;
import library.model.Book;
import library.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Book mapToModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setBookName(bookRequestDto.getBookName());
        book.setPublishedAmount(bookRequestDto.getPublishedAmount());
        book.setSoldAmount(bookRequestDto.getSoldAmount());
        book.setAuthor(authorService.getAuthorById(bookRequestDto.getAuthorId()));
        return book;
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setPublishedAmount(book.getPublishedAmount());
        bookResponseDto.setSoldAmount(book.getSoldAmount());
        bookResponseDto.setAuthorId(book.getAuthor().getId());
        return bookResponseDto;
    }
}
