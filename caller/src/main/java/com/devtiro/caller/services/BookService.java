package com.devtiro.caller.services;

import java.util.List;

import com.devtiro.caller.domain.Book;

/**
 * Service to deal with Books
 */
public interface BookService {

    List<Book> getBooks(final Integer page);

}
