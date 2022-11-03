package dev.gustavoteixeira.adapter.primary.http.seller;

import dev.gustavoteixeira.application.SalesScoreApplication;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller("/sellers")
@RequiredArgsConstructor
class SellerHttpAdapter {

    private final SalesScoreApplication application;
    private final SellerRequestMapper mapper;

    @Post
    HttpResponse<Void> create(@Body NewSellerRequest newSellerRequest) {

        return HttpResponse
                .created(URI.create(application
                        .createSeller(mapper.toNewSeller(newSellerRequest))));
    }

    @Get("/{registration}")
    HttpResponse<SellerResponse> findSellerByRegistration(@PathVariable String registration) {
        var seller = application
                .findSellerByRegistration(registration);
        var sellerResponse = mapper.toSellerResponse(seller);

        return HttpResponse.ok(sellerResponse);
    }

    @Put("/{registration}")
    HttpResponse<Void> updateSeller(@PathVariable String registration, @Body UpdateSellerRequest updateSellerRequest) {
        var updatedSeller = mapper.toUpdateSeller(updateSellerRequest);
        application.updateSeller(registration, updatedSeller);
        return HttpResponse
                .ok();
    }

    @Delete("/{registration}")
    HttpResponse<Void> deleteSeller(@PathVariable String registration) {
        application.deleteSeller(registration);
        return HttpResponse
                .ok();
    }

    @Get("/highest-sales")
    HttpResponse<List<SellerResponse>> highestSalesNumber() {
        List<SellerResponse> sellers = application
                .highestSalesNumber()
                .stream()
                .map(mapper::toSellerResponse)
                .collect(toList());

        return HttpResponse.ok(sellers);
    }

    @Get("/highest-sales-value")
    HttpResponse<List<SellerResponse>> highestSalesValue() {
        List<SellerResponse> sellers = application
                .highestSalesValue()
                .stream()
                .map(mapper::toSellerResponse)
                .collect(toList());

        return HttpResponse.ok(sellers);
    }

}
