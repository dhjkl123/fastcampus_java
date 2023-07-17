package com.example.restaurant.wishlist.repasitory;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.WishlistEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishLishRepository extends MemoryDbRepositoryAbstract<WishlistEntity> {
}
