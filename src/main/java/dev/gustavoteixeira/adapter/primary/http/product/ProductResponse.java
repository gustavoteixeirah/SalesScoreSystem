package dev.gustavoteixeira.adapter.primary.http.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductResponse {

    String id;

    String name;

    BigDecimal price;

}
