package dev.gustavoteixeira.model.sale;

import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.seller.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

import static dev.gustavoteixeira.model.validation.ConstraintValidator.validate;
import static java.math.BigDecimal.ZERO;
import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class NewSaleRecord {

    @NotNull
    Seller seller;

    @NotEmpty
    @Size(min = 1)
    List<Product> products;

    @NotNull
    @PositiveOrZero
    BigDecimal totalPrice;

    public static class NewSaleRecordBuilder {
        public NewSaleRecord build() {

            BigDecimal totalPrice = this.products
                    .stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal::add)
                    .orElse(ZERO);

            var saleRecord = new NewSaleRecord(
                    this.seller,
                    this.products,
                    totalPrice
            );

            validate(saleRecord);

            return saleRecord;
        }
    }

}
