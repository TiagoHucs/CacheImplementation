package com.hucs.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NamesController {

    @Autowired
    private NamesService service;

    @GetMapping("/names/{flt}")
    public List<String> list(@PathVariable String flt){
        return service.list(flt);
    }

    @GetMapping(value = "/names")
    public List<String> listAll(){
        return service.list(null);
    }


    @PostMapping("/names/save/{name}")
    public void save(@PathVariable String name){
        service.save(name);
    }

}
