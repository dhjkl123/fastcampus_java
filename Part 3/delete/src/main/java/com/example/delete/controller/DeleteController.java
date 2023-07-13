package com.example.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteController {
    @DeleteMapping("delete/{userid}")
    public void delete(@PathVariable String userid, @RequestParam String account){
        System.out.println(userid);
        System.out.println(account);

        return;
    }
}
