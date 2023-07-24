package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    public void put() {
        this.putBookAndAuthor();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("ssss");

        bookRepository.save(book);

        try{
            authorService.putAuthor();
        } catch (RuntimeException e){

        }


//        Author author = new Author();
//        author.setName("dddd");
//
//        authorRepository.save(author);

        throw new RuntimeException("db commit error");

    }

    @org.springframework.transaction.annotation.Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id){
        System.out.println(">>>" + bookRepository.findById(id));
        System.out.println(">>>" + bookRepository.findAll());

        System.out.println(">>>" + bookRepository.findById(id));
        System.out.println(">>>" + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();


//        Book book = bookRepository.findById(id).get();
//        book.setName("????");
//        bookRepository.save(book);
    }

    public List<Book> getAll() {
        List<Book> bookList = bookRepository.findAll();
        bookList.forEach(System.out::println);

        return bookList;
    }


}
