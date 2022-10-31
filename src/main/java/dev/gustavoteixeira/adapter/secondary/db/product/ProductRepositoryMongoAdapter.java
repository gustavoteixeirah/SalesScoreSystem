package dev.gustavoteixeira.adapter.secondary.db.product;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@MongoRepository
interface ProductRepositoryMongoAdapter extends CrudRepository<ProductDocument, String> {

    List<ProductDocument> findAll();

}
