package dev.gustavoteixeira.adapter.secondary.db.sale;

import dev.gustavoteixeira.model.sale.NewSaleRecord;
import dev.gustavoteixeira.model.sale.SaleRecordRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
class SaleRecordRepositoryImpl implements SaleRecordRepository {

    private final SaleRecordRepositoryMongoAdapter mongoAdapter;
    private final SaleRecordMapper mapper;

    @Override
    public String create(NewSaleRecord newSaleRecord) {
        var document = mapper.toDocument(newSaleRecord);

        return mongoAdapter
                .save(document)
                .getId();
    }


}
