package dev.gustavoteixeira.adapter.secondary.db.sale;

import dev.gustavoteixeira.model.sale.NewSaleRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface SaleRecordMapper {

    @Mapping(target = "id", ignore = true)
    SaleRecordDocument toDocument(NewSaleRecord newSaleRecord);

}
