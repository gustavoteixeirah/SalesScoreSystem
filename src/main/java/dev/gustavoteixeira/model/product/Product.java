package dev.gustavoteixeira.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Product {

    String id;

    String name;

    BigDecimal price;

}
