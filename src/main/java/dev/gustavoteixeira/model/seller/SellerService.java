package dev.gustavoteixeira.model.seller;

import java.math.BigDecimal;
import java.util.List;

public interface SellerService {

    Seller findByRegistration(String registration);

    String create(NewSeller newSeller);

    void update(String registration, UpdatedSeller seller);

    void delete(String registration);

    void incrementSellerTotalSalesValue(String id, BigDecimal total);

    void incrementSellerSaleCounter(String id);

    List<Seller> getSellersByHighestSalesNumber();

    List<Seller> getSellersByHighestSalesValue();

}
