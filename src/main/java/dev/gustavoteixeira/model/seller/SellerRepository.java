package dev.gustavoteixeira.model.seller;

import java.math.BigDecimal;
import java.util.List;

public interface SellerRepository {

    String create(NewSeller seller);

    void update(Seller seller);

    void delete(String id);

    Seller findByRegistration(String registration);

    void incrementSellerTotalSalesValue(String id, BigDecimal total);

    void incrementSellerSaleCounter(String id);

    List<Seller> getSellersByHighestSalesNumber();

    List<Seller> getSellersByHighestSalesValue();
}
