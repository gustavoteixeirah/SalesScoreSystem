package dev.gustavoteixeira;

import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.seller.Seller;
import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport(Seller.class)
@SerdeImport(Product.class)
public class AppRunner {
    public static void main(String[] args) {
        Micronaut.run(AppRunner.class, args);
    }
}
