package com.micro.product.services;

import com.micro.product.model.Product;

import java.util.List;

public interface CommonDao<T, D> {
    List<T> listAll();
    T getById(Long id);
    T save(D d);
    T update(D d);
    void delete(Long id);

}
