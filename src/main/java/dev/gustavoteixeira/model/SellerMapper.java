package dev.gustavoteixeira.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SellerMapper {

    @Mapping(target = "registration", ignore = true)
    Seller toSeller(NewSeller newSeller);

}
