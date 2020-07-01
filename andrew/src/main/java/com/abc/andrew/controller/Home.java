package com.abc.andrew.controller;


import com.abc.andrew.command.BookCommand;
import com.abc.andrew.dto.AuthorDTO;
import com.abc.andrew.dto.BookDTO;
import com.abc.andrew.model.Author;
import com.abc.andrew.model.Book;
import com.abc.andrew.service.AuthorService;
import com.abc.andrew.service.BookService;
import com.abc.andrew.utils.AuthorUtils;
import com.abc.andrew.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class Home {

    //    @Autowired
    private AuthorService authorService;

    @Autowired(required = true)
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    private BookService bookService;

    @Autowired(required = true)
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/books";
    }

    @RequestMapping(value = "/books")
    public ModelAndView book(@ModelAttribute BookCommand bookCommand) {
        if (bookCommand.getPage() == 0) bookCommand.setPage(1);
        bookCommand.setPageLimitItem(2);
        int pageid = bookCommand.getPage();
        bookCommand.setMaxPage((this.bookService.countTotalItem() - 1) / bookCommand.getPageLimitItem() + 1);
        List<Book> bookList = this.bookService.listBooksByPage(pageid - 1, bookCommand.getPageLimitItem());
        ModelAndView mav = new ModelAndView("listbooks");
        mav.addObject("command", bookCommand);
        mav.addObject("listBooks", bookList);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editBook(@ModelAttribute BookCommand bookCommand) {
        ModelAndView mav = new ModelAndView("editbook");
        Book book = bookService.getBookByIdFully(bookCommand.getIdBookEdit());
        BookDTO bookDTO = BookUtils.convertEntityToDto(book);
        List<Author> authorList = this.authorService.listAuthors();
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        authorList.forEach((x) -> authorDTOList.add(AuthorUtils.convertEntityToDto(x)));
        bookCommand.setPojo(bookDTO);
        mav.addObject("book", bookCommand);
        mav.addObject("listAuthor", authorDTOList);
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBook() {
        ModelAndView mav = new ModelAndView("newbook");
        BookDTO bookDTO = new BookDTO();
        List<Author> authorList = this.authorService.listAuthors();
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        authorList.forEach((x) -> authorDTOList.add(AuthorUtils.convertEntityToDto(x)));
        mav.addObject("book", bookDTO);
        mav.addObject("listAuthor", authorDTOList);
        return mav;
    }

    @RequestMapping(value = "/delete")
    public String deleteBook(@ModelAttribute BookCommand bookCommand) {
        this.bookService.removeBook(bookCommand.getIdBookEdit());
        return "redirect:/books";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute BookCommand bookCommand) {
        Book book = BookUtils.convertDtoToEntity(bookCommand.getPojo());
        Set<Author> authors = new HashSet<>();
        for (int id : bookCommand.getListID()) {
            Author author = authorService.getAuthorById(id);
            authors.add(author);
        }
        book.setListAuthor(authors);
        if (bookCommand.getPojo().getIdBook() == 0){
            book.setIdBook(null);
            this.bookService.addBook(book);
        }
        else
            this.bookService.updateBook(book);
        return "redirect:/books";
    }
}
