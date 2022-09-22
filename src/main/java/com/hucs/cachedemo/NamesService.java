package com.hucs.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NamesService {

    @Autowired
    private NamesRepository repository;

    @Autowired
    private CacheService cache;

    public List<String> list(String filtro){
        return repository.list(filtro);
    }

    public void save(String nome) {
       repository.save(nome);
    }


}
