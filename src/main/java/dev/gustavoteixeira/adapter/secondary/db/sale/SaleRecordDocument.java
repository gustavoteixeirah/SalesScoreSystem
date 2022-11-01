package dev.gustavoteixeira.adapter.secondary.db.sale;

import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.seller.Seller;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Value;

import java.util.List;

@Value
@MappedEntity
class SaleRecordDocument {

    @Id
    @GeneratedValue
    String id;

    Seller seller;

    List<Product> products;

}
