package com.hucs.cachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    private Map<String,CacheObject> map = new HashMap<>();
    private Integer lifeMinutes = 1;


    public void put(String key, Object obj){
        LOGGER.info("Cache salva key: " + key);
        map.put(key,new CacheObject(obj,LocalDateTime.now().plusMinutes(lifeMinutes)));
    }

    public Object get(String key){
        LOGGER.info("Cache retorna objeto da key: " + key);
        return map.get(key).getObject();
    }

    public boolean have(String key){
        clean();
        LOGGER.info("Cache verifica se existe key válida: " + key);
        return map.containsKey(key);
    }

    private void clean(){
        LOGGER.info("Cache limpa registros inválidos ");
        List<String> keysForRemove = new ArrayList<>();
        for (Map.Entry<String, CacheObject> entry : map.entrySet()) {
            if(!entry.getValue().isValid()){
                keysForRemove.add(entry.getKey());
            }
        }

        for (String key: keysForRemove) {
            map.remove(key);
        }
    }

    public void remove(String key){
        LOGGER.info("Cache remove a key: " + key);
        map.remove(key);
    }

    class CacheObject{


        public CacheObject(Object object, LocalDateTime date) {
            this.object = object;
            this.date = date;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public boolean isValid() {
            return LocalDateTime.now().isBefore(this.date);
        }

        Object object;
        LocalDateTime date;
    }


}
