package dev.gustavoteixeira.model.product;

import java.util.List;

public interface ProductRepository {

    String create(NewProduct newProduct);

    Product findById(String id);

    void update(Product product);

    void delete(String id);

    List<Product> list();

    void incrementProductSellCounter(String id);
}
