package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.NewSeller;
import dev.gustavoteixeira.model.Seller;
import dev.gustavoteixeira.model.UpdatedSeller;

public interface SalesScoreApplication {

    Seller findSellerByRegistration(String registration);

    String createSeller(NewSeller newSeller);

    void updateSeller(String registration, UpdatedSeller seller);

}
