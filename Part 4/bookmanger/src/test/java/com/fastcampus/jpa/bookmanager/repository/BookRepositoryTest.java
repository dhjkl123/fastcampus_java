package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.domain.Review;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void BookTest(){
//        Book book = new Book();
//        book.setName("책1");
//        book.setAuthorId(1L);
//        //book.setPublisherId(1L);
//
//        bookRepository.save(book);
//
//        System.out.println(">>>" + bookRepository.findAll());


        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());

    }

    void givenBookAndReview(){
        giveReview(giveUser(),giveBook(givePublisher()));
    }

    User giveUser(){
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    Book giveBook(Publisher publisher){
        Book book = new Book();
        book.setName("책이름");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    void giveReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("리뷰 1");
        review.setContent("내용");
        review.setScore(5);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    Publisher givePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        return publisher;
    }


}