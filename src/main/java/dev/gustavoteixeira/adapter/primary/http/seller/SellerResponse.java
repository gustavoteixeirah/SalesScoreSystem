package dev.gustavoteixeira.adapter.primary.http.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
class SellerResponse {

    String name;

    String registration;

    Integer salesCounter;

    BigDecimal totalSalesValue;

}
