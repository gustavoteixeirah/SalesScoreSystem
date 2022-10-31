package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import dev.gustavoteixeira.model.seller.UpdatedSeller;

public interface SalesScoreApplication {

    Seller findSellerByRegistration(String registration);

    String createSeller(NewSeller newSeller);

    void updateSeller(String registration, UpdatedSeller seller);

    void deleteSeller(String registration);

}
