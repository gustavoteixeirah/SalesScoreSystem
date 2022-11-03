package dev.gustavoteixeira.adapter.secondary.db.product;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@MappedEntity
class ProductDocument {

    @Id
    @GeneratedValue
    String id;

    String name;

    BigDecimal price;

    @Nullable
    Integer sellCounter;

}
