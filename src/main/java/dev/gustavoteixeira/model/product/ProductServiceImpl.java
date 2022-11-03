package dev.gustavoteixeira.model.product;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public String create(NewProduct newProduct) {
        return repository.create(newProduct);
    }

    @Override
    public void update(String id, UpdatedProduct updatedProduct) {
        var product = repository.findById(id);
        var newUpdatedProduct = mapper.update(product, updatedProduct);
        repository.update(newUpdatedProduct);

    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Product> list() {
        return repository.list();
    }

    @Override
    public void incrementProductSellCounter(String id) {
        repository.incrementProductSellCounter(id);
    }

    @Override
    public List<Product> getBestSellingItems() {
        return repository.getBestSellingItems();
    }
}
