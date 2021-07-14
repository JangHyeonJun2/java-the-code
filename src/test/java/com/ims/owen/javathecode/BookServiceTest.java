package com.ims.owen.javathecode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    void di() {
        Assertions.assertThat(bookService).isNotNull();
        Assertions.assertThat(bookService.bookRepository).isNull();
    }

}