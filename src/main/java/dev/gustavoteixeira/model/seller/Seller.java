package dev.gustavoteixeira.model.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;

import static dev.gustavoteixeira.model.validation.ConstraintValidator.validate;
import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Seller {

    @NotBlank
    String name;

    @NotBlank
    String registration;

    Integer salesCounter;

    BigDecimal totalSalesValue;

    public static class SellerBuilder {
        public Seller build() {
            var seller = new Seller(
                    this.name,
                    this.registration,
                    this.salesCounter,
                    this.totalSalesValue
            );

            validate(seller);

            return seller;
        }
    }

}