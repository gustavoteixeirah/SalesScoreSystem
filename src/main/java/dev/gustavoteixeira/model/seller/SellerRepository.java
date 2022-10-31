package dev.gustavoteixeira.model.seller;

public interface SellerRepository {

    String create(NewSeller seller);

    void update(Seller seller);

    void delete(String id);

    Seller findByRegistration(String registration);

}
