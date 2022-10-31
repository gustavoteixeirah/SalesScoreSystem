package dev.gustavoteixeira.adapter.secondary.db.product;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.product.ProductRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Singleton
@RequiredArgsConstructor
class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryMongoAdapter mongoAdapter;

    private final ProductDocumentMapper mapper;


    @Override
    public String create(NewProduct newProduct) {
        var document = mapper.toProductDocument(newProduct);
        return mongoAdapter
                .save(document)
                .getId();
    }

    @Override
    public Product findById(String id) {
        return mongoAdapter
                .findById(id)
                .map(mapper::toProduct)
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        var document = mapper.toProductDocument(product);
        mongoAdapter.update(document);
    }

    @Override
    public void delete(String id) {
        mongoAdapter.deleteById(id);
    }

    @Override
    public List<Product> list() {
        return mongoAdapter.findAll()
                .stream()
                .map(mapper::toProduct)
                .collect(toList());
    }
}
