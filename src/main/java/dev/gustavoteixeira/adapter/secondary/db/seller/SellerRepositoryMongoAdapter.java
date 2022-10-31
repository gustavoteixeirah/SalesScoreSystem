package dev.gustavoteixeira.adapter.secondary.db.seller;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
interface SellerRepositoryMongoAdapter extends CrudRepository<SellerDocument, String> {


}
