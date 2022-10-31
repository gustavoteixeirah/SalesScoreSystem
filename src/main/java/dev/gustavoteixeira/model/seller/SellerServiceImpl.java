package dev.gustavoteixeira.model.seller;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;
    private final SellerMapper mapper;

    @Override
    public String create(NewSeller newSeller) {
        return repository.create(newSeller);
    }

    @Override
    public void update(String registration, UpdatedSeller updatedSeller) {
        var seller = repository.findByRegistration(registration);
        var newUpdatedSeller = mapper.update(seller, updatedSeller);

        repository.update(newUpdatedSeller);
    }

    @Override
    public void delete(String registration) {
        repository.delete(registration);
    }

    @Override
    public Seller findByRegistration(String registration) {
        return repository.findByRegistration(registration);
    }
}