package com.devtiro.caller.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devtiro.caller.domain.Book;
import com.devtiro.caller.domain.PagedResponse;
import com.devtiro.caller.services.BookService;
import com.devtiro.caller.services.BooksClient;

@Service
public class BookServiceImpl implements BookService {

    private final BooksClient booksClient;

    public BookServiceImpl(final BooksClient booksClient) {
        this.booksClient=booksClient;
    }

    public List<Book> getBooks(final Integer page) {
        final PagedResponse<Book> response = booksClient.getBooks(page);
        return response.getContent();
    }

}
