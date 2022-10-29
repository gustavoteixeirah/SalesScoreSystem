package dev.gustavoteixeira.model;

public interface SellerRepository {

    String create(Seller seller);

    Seller findByRegistration(String registration);

}
