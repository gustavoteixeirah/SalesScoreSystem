package dev.gustavoteixeira.adapter.primary.http.seller;

import dev.gustavoteixeira.model.UpdatedSeller;
import org.mapstruct.Mapper;

@Mapper
interface SellerRequestMapper {

    UpdatedSeller toUpdateSeller(UpdateSellerRequest updateSellerRequest);

}
