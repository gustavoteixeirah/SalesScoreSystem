package dev.gustavoteixeira.adapter.secondary.db.product;

import dev.gustavoteixeira.model.product.NewProduct;
import dev.gustavoteixeira.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface ProductDocumentMapper {

    ProductDocument toProductDocument(Product product);

    Product toProduct(ProductDocument product);

    @Mapping(target = "id", ignore = true)
    ProductDocument toProductDocument(NewProduct newProduct);

}
