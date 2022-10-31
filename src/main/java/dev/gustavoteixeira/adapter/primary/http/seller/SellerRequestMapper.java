package dev.gustavoteixeira.adapter.primary.http.seller;

import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import dev.gustavoteixeira.model.seller.UpdatedSeller;
import org.mapstruct.Mapper;

@Mapper
interface SellerRequestMapper {

    UpdatedSeller toUpdateSeller(UpdateSellerRequest updateSellerRequest);

    SellerResponse toSellerResponse(Seller seller);

    NewSeller toNewSeller(NewSellerRequest newSellerRequest);

}
