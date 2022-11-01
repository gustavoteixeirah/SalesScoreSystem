package dev.gustavoteixeira.adapter.primary.http.sale;

import dev.gustavoteixeira.model.sale.NewSaleRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface SaleRecordMapper {

    @Mapping(target = "totalPrice", ignore = true)
    NewSaleRecord toNewSaleRecord(SaleRecordRequest saleRecordRequest);

}
