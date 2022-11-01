package dev.gustavoteixeira.adapter.primary.http.sale;

import dev.gustavoteixeira.application.SalesScoreApplication;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@Controller("/sales")
@RequiredArgsConstructor
class SaleRecordHttpAdapter {

    private final SalesScoreApplication application;
    private final SaleRecordMapper mapper;

    @Post
    HttpResponse<Void> create(@Body SaleRecordRequest saleRecordRequest) {

        return HttpResponse
                .created(URI.create(application
                        .create(mapper.toNewSaleRecord(saleRecordRequest))));
    }

}
