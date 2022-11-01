package dev.gustavoteixeira.adapter.secondary.db.sale;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
interface SaleRecordRepositoryMongoAdapter extends CrudRepository<SaleRecordDocument, String> {

}
