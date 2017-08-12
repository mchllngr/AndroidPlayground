package de.mchllngr.androidplayground.util.functional;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);
}
