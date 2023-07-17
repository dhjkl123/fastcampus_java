package com.example.restaurant.comtroller;

import com.example.restaurant.wishlist.dto.WishlistEntityDto;
import com.example.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishlistEntityDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishlistEntityDto add(@RequestBody WishlistEntityDto wishlistEntityDto){
        return wishListService.add(wishlistEntityDto);
    }

    @GetMapping("/all")
    public List<WishlistEntityDto> findAll(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }


}
