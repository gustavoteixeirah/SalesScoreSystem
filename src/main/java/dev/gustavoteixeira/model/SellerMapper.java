package dev.gustavoteixeira.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface SellerMapper {

    @Mapping(target = "registration", ignore = true)
    Seller toSeller(NewSeller newSeller);

    @Mapping(target = "registration", ignore = true)
    Seller update(@MappingTarget Seller seller, UpdatedSeller updatedSeller);

}
