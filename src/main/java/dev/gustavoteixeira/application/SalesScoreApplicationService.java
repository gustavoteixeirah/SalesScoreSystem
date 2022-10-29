package dev.gustavoteixeira.application;

import dev.gustavoteixeira.model.NewSeller;
import dev.gustavoteixeira.model.Seller;
import dev.gustavoteixeira.model.SellerMapper;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Singleton
@RequiredArgsConstructor
class SalesScoreApplicationService implements SalesScoreApplication {


    private final List<Seller> inMemoryDatabase;
    private final SellerMapper sellerMapper;

    @Override
    public String createSeller(NewSeller newSeller) {
        Seller seller = sellerMapper.toSeller(newSeller);
        inMemoryDatabase.add(seller);
        return String.valueOf(Math.random() * 100);
    }

    @Override
    public Seller findSellerByRegistration(String registration) {
        return Seller.builder()
                .name("It still works!")
                .registration(registration)
                .build();
    }

}
