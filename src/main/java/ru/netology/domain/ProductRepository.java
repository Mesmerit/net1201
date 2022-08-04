package ru.netology.domain;

import java.util.Arrays;
import java.util.Optional;

import ru.netology.domain.ProductManager;

public class ProductRepository {

    Product[] products = new Product[0];

    public void saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] getAllProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product result = findById(id);
        if (result == null) {
            return;
        }
        Product[] tmp = new Product[products.length - 1];
        int k = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != id) {
                tmp[k] = products[i];
                k++;
            }
        }
        products = tmp;
    }
}
