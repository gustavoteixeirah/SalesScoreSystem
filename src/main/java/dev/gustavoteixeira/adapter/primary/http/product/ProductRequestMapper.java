package dev.gustavoteixeira.adapter.primary.http.product;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
interface ProductRequestMapper {

    NewProduct toNewProduct(NewProductRequest newProductRequest);

    List<ProductResponse> toProductReponseList(List<Product> products);

}
