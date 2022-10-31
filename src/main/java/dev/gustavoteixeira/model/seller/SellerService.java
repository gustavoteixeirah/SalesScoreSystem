package dev.gustavoteixeira.model.seller;

public interface SellerService {

    Seller findByRegistration(String registration);

    String create(NewSeller newSeller);

    void update(String registration, UpdatedSeller seller);

    void delete(String registration);

}
