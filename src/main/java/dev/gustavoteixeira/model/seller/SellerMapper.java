package dev.gustavoteixeira.model.seller;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface SellerMapper {

    @Mapping(target = "registration", ignore = true)
    Seller update(@MappingTarget Seller seller, UpdatedSeller updatedSeller);

}
