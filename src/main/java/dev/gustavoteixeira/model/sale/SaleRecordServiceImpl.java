package dev.gustavoteixeira.model.sale;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
class SaleRecordServiceImpl implements SaleRecordService {

    private final SaleRecordRepository repository;


    @Override
    public String create(NewSaleRecord newSaleRecord) {
        return repository.create(newSaleRecord);
    }

}
