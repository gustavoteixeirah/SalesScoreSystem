package dev.gustavoteixeira.adapter.primary.http.product;

import dev.gustavoteixeira.application.SalesScoreApplication;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@Controller("/products")
@RequiredArgsConstructor
class ProductHttpAdapter {

    private final SalesScoreApplication application;
    private final ProductRequestMapper mapper;

    @Post
    HttpResponse<Void> create(@Body NewProductRequest newProductRequest) {
        return HttpResponse
                .created(URI.create(application
                        .createProduct(mapper.toNewProduct(newProductRequest))));
    }

    @Get
    HttpResponse<List<ProductResponse>> findById() {
        var products = application.listProducts();
        return HttpResponse.ok(mapper.toProductReponseList(products));
    }

    @Put("/{id}")
    HttpResponse<Void> updateSeller(@PathVariable String id, @Body UpdateProductRequest updateProductRequest) {
        var updatedProduct = mapper.toUpdateProduct(updateProductRequest);
        application.updateProduct(id, updatedProduct);
        return HttpResponse.ok();
    }


}
