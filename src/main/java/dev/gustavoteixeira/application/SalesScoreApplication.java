package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.NewSeller;
import dev.gustavoteixeira.model.Seller;

public interface SalesScoreApplication {

    Seller findSellerByRegistration(String registration);

    String createSeller(NewSeller newSeller);

}
