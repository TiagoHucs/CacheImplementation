package com.hucs.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NamesService {

    @Autowired
    private NamesRepository repository;

    @Cacheable("namescache")
    public List<String> list(String filtro){
        System.out.println("buscou no serviço");
        return repository.list(filtro);
    }

    @CacheEvict("namescache")
    public void save(String nome) {
       repository.save(nome);
    }
}
