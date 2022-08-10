package ru.netology.domain;

import ru.netology.domain.Product;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] products = repository.getAllProducts();
        Product[] result = new Product[0];
        for (int i = 0; i < products.length; i++) {
            if (products[i].matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int k = 0; k < result.length; k++) {
                    tmp[k] = result[k];
                }
                tmp[result.length] = products[i];
                result = tmp;
            }
        }
        if (result.length != 0) {
            return result;
        } else {
            return null;
        }
    }
}