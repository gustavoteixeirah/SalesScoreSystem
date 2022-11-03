package dev.gustavoteixeira.adapter.secondary.db.seller;

import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface SellerDocumentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "salesCounter", ignore = true)
    @Mapping(target = "totalSalesValue", ignore = true)
    SellerDocument toSellerDocument(NewSeller newSeller);

    @Mapping(target = "registration", source = "id")
    Seller toSeller(SellerDocument newSeller);

    @Mapping(target = "id", source = "registration")
    SellerDocument toSellerDocument(Seller seller);

}
