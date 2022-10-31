package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.*;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
class SalesScoreApplicationService implements SalesScoreApplication {


    private final SellerRepository sellerRepository;
    private final SellerMapper mapper;

    @Override
    public String createSeller(NewSeller newSeller) {
        return sellerRepository.create(newSeller);
    }

    @Override
    public void updateSeller(String registration, UpdatedSeller updatedSeller) {
        var seller = sellerRepository.findByRegistration(registration);
        Seller updatedSellerr = mapper.update(seller, updatedSeller);

        sellerRepository.update(updatedSellerr);
    }


    @Override
    public Seller findSellerByRegistration(String registration) {
        return sellerRepository.findByRegistration(registration);
    }

}
