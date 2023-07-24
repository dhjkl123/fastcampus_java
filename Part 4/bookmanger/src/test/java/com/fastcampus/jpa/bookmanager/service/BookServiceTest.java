package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import com.fastcampus.jpa.bookmanager.repository.PublisherRepository;
import com.fastcampus.jpa.bookmanager.repository.dto.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void transactionTest() {
        try {
            bookService.put();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("book : " + bookRepository.findAll());
        System.out.println("author : " + authorRepository.findAll());
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("asdasd");

        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(">>>" + bookRepository.findAll());
    }

    @Transactional
    @Test
    void bookCascadeTest(){
//        Book book = new Book();
//        book.setName("책이름");

//        bookRepository.save(book);

//        Publisher publisher = new Publisher();
//        publisher.setName("패스트캠퍼스");

//        publisherRepository.save(publisher);

//        book.setPublisher(publisher);
//        bookRepository.save(book);

//        publisher.getBooks().add(book);
//        publisherRepository.save(publisher);

//        System.out.println("books : " + bookRepository.findAll());
//        System.out.println("publisher : " + publisherRepository.findAll());
//
//        Book book1 = bookRepository.findById(1L).get();
//        book1.getPublisher().setName("ㅁㄴㅇㅁㄴ");
//
//        bookRepository.save(book1);
//
//        System.out.println("publisher : " + publisherRepository.findAll());
//
//        Book book2 = bookRepository.findById(1L).get();
        //bookRepository.delete(book2);

//        System.out.println("books : " + bookRepository.findAll());
//        System.out.println("publisher : " + publisherRepository.findAll());

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3-publisher : " + bookRepository.findById(1L).get().getPublisher());

    }

    @Test
    @Transactional
    void bookRemoveCascadeTest(){

        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void queryTest(){
//        bookRepository.findAll().forEach(System.out::println);
//
//        System.out.println("findByNameRecently : " + bookRepository.findByNameRecently("스프링 시큐리티 초격차 패키지",
//                LocalDateTime.now().minusDays(1L),
//                LocalDateTime.now().minusDays(1L)
//                ));

        //System.out.println("findByNameRecently : " + bookRepository.findBookNameandCategory().stream().forEach(System.out::println););
        bookRepository.findBookNameandCategory().stream().forEach(b -> System.out.println(b.getName()));
    }

    @Test
    void nativeQueryTest(){
        List<Book> bookList = bookRepository.findAll();

        for(Book book : bookList){
            book.setCategory("IT");
        }

        bookRepository.saveAll(bookList);

        System.out.println(bookRepository.findAll());
        System.out.println("---------------------------------");
        System.out.println(bookRepository.updateCategory());


    }

    @Test
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);

        Book book = new Book();
        book.setName("IT");
        book.setStatus(new BookStatus(200));

        bookRepository.save(book);

        System.out.println(bookRepository.findRawRecord().values());
    }

    @Test
    void converterErrorTest() {
        //bookService.getAll();

        Book book = new Book();
        book.setName("IT");
        book.setStatus(new BookStatus(200));

        bookRepository.save(book);

        System.out.println(bookRepository.findRawRecord().values());

        bookRepository.findAll().forEach(System.out::println);
    }
}