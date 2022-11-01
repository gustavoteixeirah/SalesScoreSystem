package dev.gustavoteixeira.model.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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

    public static class SellerBuilder {
        public Seller build() {
            var seller = new Seller(
                    this.name,
                    this.registration
            );

            validate(seller);

            return seller;
        }
    }

}