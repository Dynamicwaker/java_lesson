package com.dynamic.interview.foundation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: xinghj0308@gmail.com
 * @create: 2021/12/20
 * @description:
 */
public class Favorties {
    private Map<Class<?>, Object> favorties = new HashMap<>();

    public <T> void putFavorties(Class<T> type, T instance) {
        favorties.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorties.get(type));
    }

    public static void main(String[] args) {
        Favorties f = new Favorties();
        f.putFavorties(String.class, "java");
        f.putFavorties(Integer.class, 16);
        f.putFavorties(Class.class, Favorties.class);

        String favoriteString = 
    }
}
