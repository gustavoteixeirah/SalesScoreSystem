package dev.gustavoteixeira.adapter.secondary.db.seller;

import dev.gustavoteixeira.model.seller.NewSeller;
import dev.gustavoteixeira.model.seller.Seller;
import dev.gustavoteixeira.model.seller.SellerRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static io.micronaut.data.model.Sort.Order.desc;
import static io.micronaut.data.model.Sort.of;
import static java.util.stream.Collectors.toList;

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
        mongoAdapter.deleteById(id);
    }

    @Override
    public Seller findByRegistration(String registration) {
        return mongoAdapter
                .findById(registration)
                .map(mapper::toSeller)
                .orElse(null);
    }

    @Override
    public void incrementSellerTotalSalesValue(String id, BigDecimal total) {
        mongoAdapter.incrementSellerTotalSalesValue(id, total);
    }

    @Override
    public void incrementSellerSaleCounter(String id) {
        mongoAdapter.incrementSellerSaleCounter(id);
    }

    @Override
    public List<Seller> getSellersByHighestSalesNumber() {
        return mongoAdapter
                .findAll(of(desc("salesCounter")))
                .stream()
                .map(mapper::toSeller)
                .collect(toList());
    }

    @Override
    public List<Seller> getSellersByHighestSalesValue() {
        return mongoAdapter
                .findAll(of(desc("totalSalesValue")))
                .stream()
                .map(mapper::toSeller)
                .collect(toList());
    }

}
