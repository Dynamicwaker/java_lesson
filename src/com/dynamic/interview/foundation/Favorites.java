package com.dynamic.interview.foundation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: xinghj0308@gmail.com
 * @create: 2021/12/20
 * @description:
 */
public class Favorites {
    private Map<Class<?>, Object> favorties = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        favorties.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorties.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorites(String.class, "java");
        f.putFavorites(Integer.class, 16);
        f.putFavorites(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
