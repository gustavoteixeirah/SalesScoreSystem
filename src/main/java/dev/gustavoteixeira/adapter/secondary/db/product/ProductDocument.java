package dev.gustavoteixeira.adapter.secondary.db.product;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Value;

import java.math.BigDecimal;

@Value
@MappedEntity
class ProductDocument {

    @Id
    @GeneratedValue
    String id;

    String name;

    BigDecimal price;

}
