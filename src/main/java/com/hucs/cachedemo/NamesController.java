package com.hucs.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NamesController {

    @Autowired
    private NamesService service;

    @GetMapping("/names/{filtro}")
    @Cacheable("namescache")
    public List<String> list(@PathVariable String filtro){
        return service.list(filtro);
    }

    @GetMapping("/names/save/{name}")
    public void save(@PathVariable String name){
        service.save(name);
    }

}
