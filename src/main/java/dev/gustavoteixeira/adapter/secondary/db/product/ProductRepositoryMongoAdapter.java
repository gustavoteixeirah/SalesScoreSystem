package dev.gustavoteixeira.adapter.secondary.db.product;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.mongodb.annotation.MongoUpdateOptions;
import io.micronaut.data.mongodb.annotation.MongoUpdateQuery;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@MongoRepository
interface ProductRepositoryMongoAdapter extends CrudRepository<ProductDocument, String> {

    List<ProductDocument> findAll();


//    teixeira.seller_document.update({id: '636067498f217a2eb563ead0' }, { $inc: { sellCounter: 1 }})
    @MongoUpdateQuery(filter = "{_id: :id }", update = "{ $inc: { sellCounter: 1 }}")
    void incrementProductSellCounter(String id);


}
