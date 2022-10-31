package dev.gustavoteixeira.model;

public interface SellerRepository {

    String create(NewSeller seller);

    void update(Seller seller);

    void delete(String id);

    Seller findByRegistration(String registration);

}
