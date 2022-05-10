package com.hucs.cachedemo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<LocalDateTime> registers = new ArrayList<>();

    @GetMapping("/list")
    @Cacheable("registers")
    public List<LocalDateTime> list(){
        System.out.println("buscou do banco");
        return registers;
    }

    @GetMapping("/save")
    @CacheEvict("registers")
    public String save(){
        registers.add(LocalDateTime.now());
        System.out.println("Salvou do banco");
        return "Salvou no banco";
    }

}
