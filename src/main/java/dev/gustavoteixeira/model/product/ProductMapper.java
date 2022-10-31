package dev.gustavoteixeira.model.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product update(@MappingTarget Product product, UpdatedProduct updatedProduct);

}
