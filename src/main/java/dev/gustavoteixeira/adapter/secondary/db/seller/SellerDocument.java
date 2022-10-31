package dev.gustavoteixeira.adapter.secondary.db.seller;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Value;

@Value
@MappedEntity
class SellerDocument {

    @Id
    @GeneratedValue
    String id;

    String name;


}
