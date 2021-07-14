package com.ims.owen.javathecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {
    @Test
    void getObject_BookRepository() {
        BookRepository object = ContainerService.getObject(BookRepository.class);
        assertNotNull(object);
    }

    @Test
    void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

}