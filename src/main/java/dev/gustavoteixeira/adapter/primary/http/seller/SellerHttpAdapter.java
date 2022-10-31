package dev.gustavoteixeira.adapter.primary.http.seller;

import dev.gustavoteixeira.application.SalesScoreApplication;
import dev.gustavoteixeira.model.NewSeller;
import dev.gustavoteixeira.model.Seller;
import dev.gustavoteixeira.model.UpdatedSeller;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@Controller("/sellers")
@RequiredArgsConstructor
class SellerHttpAdapter {

    private final SalesScoreApplication salesScoreApplication;
    private final SellerRequestMapper mapper;

    @Post
    HttpResponse<String> create(@Body NewSellerRequest newSeller) {

        return HttpResponse
                .created(URI.create(salesScoreApplication
                        .createSeller(NewSeller.builder().name(newSeller.getName()).build())));
    }

    @Get("/{registration}")
    HttpResponse<Seller> findSellerByRegistration(@PathVariable String registration) {

        return HttpResponse
                .ok(salesScoreApplication
                        .findSellerByRegistration(registration));
    }

    @Put("/{registration}")
    HttpResponse<Void> updateSeller(@PathVariable String registration, @Body UpdateSellerRequest updateSellerRequest) {
        var updatedSeller = mapper.toUpdateSeller(updateSellerRequest);
        salesScoreApplication.updateSeller(registration, updatedSeller);
        return HttpResponse
                .ok();
    }

}
