package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import dev.gustavoteixeira.model.seller.SellerService;
import dev.gustavoteixeira.model.seller.UpdatedSeller;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
class SalesScoreApplicationService implements SalesScoreApplication {

    private final SellerService sellerService;

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
}
