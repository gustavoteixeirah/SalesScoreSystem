package dev.gustavoteixeira.adapter.primary.http.seller;

import dev.gustavoteixeira.application.SalesScoreApplication;
import dev.gustavoteixeira.model.NewSeller;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

@Controller("/sellers")
@RequiredArgsConstructor
class SellerHttpAdapter {

    private final SalesScoreApplication salesScoreApplication;

    @Get
    HttpResponse<String> findSellerByRegistration() {
        String randomNumber = salesScoreApplication.createSeller(NewSeller.builder().name("Romanov").build());

        return HttpResponse
                .ok(salesScoreApplication
                        .findSellerByRegistration(String.valueOf(randomNumber))
                        .getRegistration());
    }

}
