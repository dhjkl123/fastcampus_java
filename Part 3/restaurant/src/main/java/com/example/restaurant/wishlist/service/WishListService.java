package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.WishlistEntity;
import com.example.restaurant.wishlist.dto.WishlistEntityDto;
import com.example.restaurant.wishlist.repasitory.WishLishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishLishRepository wishLishRepository;

    public WishlistEntityDto search(String query){
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);
        if(searchLocalRes.getTotal() > 0){
            var localitem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localitem.getTitle().replaceAll("<[^>]*>","");

            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal() > 0){
                var imageitem = searchImageRes.getItems().stream().findFirst().get();

                var result = new WishlistEntityDto();
                result.setTitle(localitem.getTitle());
                result.setCategory(localitem.getCategory());
                result.setAddress(localitem.getAddress());
                result.setReadAddress(localitem.getRoadAddress());
                result.setHomePageLink(localitem.getLink());
                result.setImageLink(imageitem.getLink());

                return result;

            }
        }
        return new WishlistEntityDto();
    }

    public WishlistEntityDto add(WishlistEntityDto wishlistEntityDto) {
        var entity = dtoToEntiy(wishlistEntityDto);
        var saveEntity = wishLishRepository.save(entity);
        return EntiyTodto(saveEntity);
    }

    private WishlistEntityDto EntiyTodto(WishlistEntity wishlistEntity){
        var dto = new WishlistEntityDto();
        dto.setIndex(wishlistEntity.getIndex());
        dto.setTitle(wishlistEntity.getTitle());
        dto.setCategory(wishlistEntity.getCategory());
        dto.setAddress(wishlistEntity.getAddress());
        dto.setReadAddress(wishlistEntity.getReadAddress());
        dto.setHomePageLink(wishlistEntity.getHomePageLink());
        dto.setImageLink(wishlistEntity.getImageLink());
        dto.setVisit(wishlistEntity.isVisit());
        dto.setVisitCount(wishlistEntity.getVisitCount());
        dto.setLastVisitDate(wishlistEntity.getLastVisitDate());

        return dto;
    }
    private WishlistEntity dtoToEntiy(WishlistEntityDto wishlistEntityDto){
        var entity = new WishlistEntity();
        entity.setIndex(wishlistEntityDto.getIndex());
        entity.setTitle(wishlistEntityDto.getTitle());
        entity.setCategory(wishlistEntityDto.getCategory());
        entity.setAddress(wishlistEntityDto.getAddress());
        entity.setReadAddress(wishlistEntityDto.getReadAddress());
        entity.setHomePageLink(wishlistEntityDto.getHomePageLink());
        entity.setImageLink(wishlistEntityDto.getImageLink());
        entity.setVisit(wishlistEntityDto.isVisit());
        entity.setVisitCount(wishlistEntityDto.getVisitCount());
        entity.setLastVisitDate(wishlistEntityDto.getLastVisitDate());

        return entity;
    }

    public List<WishlistEntityDto> findAll(){
        return wishLishRepository.findAll().stream().map(it->EntiyTodto(it)).collect(Collectors.toList());
    }

    public void delete(int index){
        wishLishRepository.deleteById(index);
    }

    public void addVisit(int index){
        var wishItem = wishLishRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }
}
