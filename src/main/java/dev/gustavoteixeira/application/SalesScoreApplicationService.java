package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import dev.gustavoteixeira.model.product.ProductService;
import dev.gustavoteixeira.model.product.UpdatedProduct;
import dev.gustavoteixeira.model.sale.NewSaleRecord;
import dev.gustavoteixeira.model.sale.SaleRecordService;
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
    private final SaleRecordService saleRecordService;

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
    public List<Product> listProducts() {
        return productService.list();
    }

    @Override
    public String create(NewSaleRecord newSaleRecord) {
        String id = saleRecordService.create(newSaleRecord);
        sellerService.incrementSellerSaleCounter(newSaleRecord.getSeller().getRegistration());
        sellerService.incrementSellerTotalSalesValue(newSaleRecord.getSeller().getRegistration(), newSaleRecord.getTotalPrice());

        for (Product product : newSaleRecord.getProducts()) {
            productService.incrementProductSellCounter(product.getId());
        }

        return id;
    }


}
