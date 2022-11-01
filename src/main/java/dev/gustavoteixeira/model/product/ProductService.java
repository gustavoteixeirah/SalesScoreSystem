package dev.gustavoteixeira.model.product;

import java.util.List;

public interface ProductService {

    String create(NewProduct newProduct);

    void update(String id, UpdatedProduct product);

    void delete(String id);

    List<Product> list();

    void incrementProductSellCounter(String id);

}
