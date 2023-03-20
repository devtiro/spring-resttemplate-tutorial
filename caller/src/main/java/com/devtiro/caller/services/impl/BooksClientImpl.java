package com.devtiro.caller.services.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.devtiro.caller.domain.Book;
import com.devtiro.caller.domain.PagedResponse;
import com.devtiro.caller.exceptions.BookClientException;
import com.devtiro.caller.services.BooksClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BooksClientImpl implements BooksClient {

    private final RestTemplate restTemplate;

    public BooksClientImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PagedResponse<Book> getBooks(Integer page) {
        final ParameterizedTypeReference<PagedResponse<Book>> pagedResponseBooks = new ParameterizedTypeReference<PagedResponse<Book>>() {
        };

        try {
            final ResponseEntity<PagedResponse<Book>> response = restTemplate.exchange(
                    "http://localhost:8181/books?page={page}", HttpMethod.GET, null, pagedResponseBooks, page);

            if (!response.getStatusCode().is2xxSuccessful()) {
                log.debug(response.getBody().toString());
                throw new BookClientException("Non 200 response from Books API");
            }

            return response.getBody();

        } catch (RestClientException ex) {
            throw new BookClientException(ex);
        }
    }

}
