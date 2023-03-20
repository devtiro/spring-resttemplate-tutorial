package com.devtiro.caller.services;

import com.devtiro.caller.domain.Book;
import com.devtiro.caller.domain.PagedResponse;

/**
 * Handles HTTP calls to the Books server
 */
public interface BooksClient {

    PagedResponse<Book> getBooks(Integer page);

}
