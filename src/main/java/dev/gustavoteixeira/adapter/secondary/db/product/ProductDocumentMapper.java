package dev.gustavoteixeira.adapter.secondary.db.product;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface ProductDocumentMapper {

    @Mapping(source = "sellCounter", target = "sellCounter", defaultValue = "0")
    ProductDocument toProductDocument(Product product);


    @Mapping(source = "sellCounter", target = "sellCounter", defaultValue = "0")
    Product toProduct(ProductDocument product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sellCounter", ignore = true)
    ProductDocument toProductDocument(NewProduct newProduct);

}
