package dev.gustavoteixeira.model.product;

import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

import static dev.gustavoteixeira.model.validation.ConstraintValidator.validate;
import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Product {

    @NotBlank
    String id;

    @NotBlank
    String name;

    @NotNull
    @PositiveOrZero
    BigDecimal price;

    public static class ProductBuilder {


        public Product build() {
            var product = new Product(
                    this.id,
                    this.name,
                    this.price
            );

            validate(product);

            return product;
        }
    }

}
