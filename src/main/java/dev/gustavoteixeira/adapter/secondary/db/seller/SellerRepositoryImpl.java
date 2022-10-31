package dev.gustavoteixeira.adapter.secondary.db.seller;

import dev.gustavoteixeira.model.NewSeller;
import dev.gustavoteixeira.model.Seller;
import dev.gustavoteixeira.model.SellerRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
class SellerRepositoryImpl implements SellerRepository {

    private final SellerRepositoryMongoAdapter mongoAdapter;
    private final SellerDocumentMapper mapper;

    @Override
    public String create(NewSeller seller) {

        var document = mapper.toSellerDocument(seller);
        var savedDocument = mongoAdapter.save(document);

        return savedDocument.getId();
    }

    @Override
    public void update(Seller seller) {
        var document = mapper.toSellerDocument(seller);
        mongoAdapter.update(document);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Seller findByRegistration(String registration) {
        return mongoAdapter
                .findById(registration)
                .map(mapper::toSeller)
                .orElse(null);
    }

}
