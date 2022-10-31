package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.product.ProductService;
import dev.gustavoteixeira.model.product.UpdatedProduct;
import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import dev.gustavoteixeira.model.seller.SellerService;
import dev.gustavoteixeira.model.seller.UpdatedSeller;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Singleton
@RequiredArgsConstructor
class SalesScoreApplicationService implements SalesScoreApplication {

    private final SellerService sellerService;
    private final ProductService productService;

    @Override
    public Seller findSellerByRegistration(String registration) {
        return sellerService.findByRegistration(registration);
    }

    @Override
    public String createSeller(NewSeller newSeller) {
        return sellerService.create(newSeller);
    }

    @Override
    public void updateSeller(String registration, UpdatedSeller seller) {
        sellerService.update(registration, seller);
    }

    @Override
    public void deleteSeller(String registration) {
        sellerService.delete(registration);
    }

    @Override
    public String createProduct(NewProduct newProduct) {
        return productService.create(newProduct);
    }

    @Override
    public void updateProduct(String id, UpdatedProduct product) {
        productService.update(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        productService.delete(id);
    }

    @Override
    public List<Product> listProducts() {
        return productService.list();
    }
}
