package dev.gustavoteixeira.adapter.primary.http.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductRequest {

    String id;

    String name;

    BigDecimal price;
}
