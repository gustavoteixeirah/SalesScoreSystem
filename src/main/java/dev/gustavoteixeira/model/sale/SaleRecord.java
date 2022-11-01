package dev.gustavoteixeira.model.sale;

import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.seller.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

import static dev.gustavoteixeira.model.validation.ConstraintValidator.validate;
import static java.math.BigDecimal.ZERO;
import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class SaleRecord {

    @NotBlank
    String id;

    @NotNull
    Seller seller;

    @NotEmpty
    @Size(min = 1)
    List<Product> products;

    @NotNull
    @PositiveOrZero
    BigDecimal totalPrice;

    public static class SaleRecordBuilder {
        public SaleRecord build() {

            BigDecimal totalPrice = this.products
                    .stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal::add)
                    .orElse(ZERO);

            var saleRecord = new SaleRecord(
                    this.id,
                    this.seller,
                    this.products,
                    totalPrice
            );

            validate(saleRecord);

            return saleRecord;
        }
    }

}
