package dev.gustavoteixeira.adapter.primary.http.seller;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

@MicronautTest
class SellerHttpAdapterTest {

    @Test
    void testSellerHttpAdapter(RequestSpecification spec) {
        spec
                .when()
                .get("/sellers")
                .then()
                .statusCode(200)
                .body(is("963"));
    }

}