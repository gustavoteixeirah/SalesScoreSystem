package dev.gustavoteixeira.adapter.secondary.db.seller;

import io.micronaut.data.model.Sort;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.mongodb.annotation.MongoUpdateQuery;
import io.micronaut.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

@MongoRepository
interface SellerRepositoryMongoAdapter extends CrudRepository<SellerDocument, String> {

    @MongoUpdateQuery(filter = "{_id: :id}", update = "{ $inc: { salesCounter: 1 }}")
    SellerDocument incrementSellerSaleCounter(String id);

    @MongoUpdateQuery(filter = "{_id: :id }", update = "{ $inc: { totalSalesValue: :total }}")
    SellerDocument incrementSellerTotalSalesValue(String id, BigDecimal total);

    List<SellerDocument> findAll(Sort sort);
}
