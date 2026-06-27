package com.library.librarymanagement.service;

import com.library.librarymanagement.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {

        System.out.println("Book Service Called");

        bookRepository.displayRepository();
    }
}
