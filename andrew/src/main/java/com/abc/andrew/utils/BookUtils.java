package com.abc.andrew.utils;

import com.abc.andrew.dto.AuthorDTO;
import com.abc.andrew.dto.BookDTO;
import com.abc.andrew.model.Author;
import com.abc.andrew.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookUtils {
    public static BookDTO convertEntityToDto(Book book) {
        List<AuthorDTO> authorList = new ArrayList<>();// = new HashSet<>();
        for (Author author : book.getListAuthor()) {
            System.out.println(author.toString());
            authorList.add(new AuthorDTO(author.getIdAuthor(), author.getName()));
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setCategoryDate(book.getCategoryDate());
        bookDTO.setIdBook(book.getIdBook());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setNameBook(book.getNameBook());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setIssueDate(book.getIssueDate());

        bookDTO.setListAuthor(authorList);

        System.out.println(bookDTO.toString());

        for (AuthorDTO authorDTO : bookDTO.getListAuthor()) {
            System.out.println(authorDTO.toString());
        }

//        AuthorDTO authorDTO = book.getListAuthor();
//        bookDTO.setListAuthor(bookService);
        return bookDTO;
    }

    public static Book convertDtoToEntity(BookDTO bookDTO) {
        Book book = new Book();
//        if (bookDTO.getIdBook() != 0) {
//            book = this.bookService.getBookByIdFully(bookDTO.getIdBook());
//            // Update attributes
//
//        } else {
//            book = new Book();
//        }

        // Update attributes
        book.setIdBook(bookDTO.getIdBook());
        book.setIssueDate(bookDTO.getIssueDate());
        book.setNameBook(bookDTO.getNameBook());
        book.setCategoryDate(bookDTO.getCategoryDate());
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        return book;
    }
}

