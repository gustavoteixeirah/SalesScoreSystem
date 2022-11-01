package dev.gustavoteixeira.adapter.primary.http.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class SaleRecordRequest {

    SellerRequest seller;

    List<ProductRequest> products;
}
