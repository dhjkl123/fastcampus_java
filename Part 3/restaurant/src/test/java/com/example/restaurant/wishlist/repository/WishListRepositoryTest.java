package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.WishlistEntity;
import com.example.restaurant.wishlist.repasitory.WishLishRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishLishRepository wishLishRepository;

    private WishlistEntity create(){
        var wishList = new WishlistEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setReadAddress("readaddress");
        wishList.setHomePageLink("homepagelink");
        wishList.setVisit(true);
        wishList.setImageLink("");
        wishList.setVisitCount(1);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishLishRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());

    }

    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishLishRepository.save(wishListEntity);

        expected.setTitle("update title");

        var updateexpected =wishLishRepository.save(expected);
        int count = wishLishRepository.findAll().size();

        Assertions.assertEquals("update title",updateexpected.getTitle());
        Assertions.assertEquals(1,count);

    }

    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishLishRepository.save(wishListEntity);
        wishLishRepository.deleteById(1);

        int count = wishLishRepository.findAll().size();

        Assertions.assertEquals(0,count);

    }

    @Test
    public  void findByIdTest(){
        var wishListEntity = create();
        wishLishRepository.save(wishListEntity);
        var expected = wishLishRepository.findById(1);


        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());
    }

    @Test
    public void listAllTest() {
        var wishListEntity1 = create();
        wishLishRepository.save(wishListEntity1);

        var wishListEntity2 = create();
        wishLishRepository.save(wishListEntity2);

        int count = wishLishRepository.findAll().size();
        Assertions.assertEquals(2,count);
    }

}
