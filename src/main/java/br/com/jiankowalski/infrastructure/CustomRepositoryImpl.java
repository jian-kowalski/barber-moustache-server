package br.com.jiankowalski.infrastructure;

import br.com.jiankowalski.domain.repository.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class CustomRepositoryImpl<T, ID> extends SimpleMongoRepository<T, ID>
    implements CustomRepository<T, ID> {

  public CustomRepositoryImpl(
      MongoEntityInformation<T, ID> entityInformation, MongoTemplate mongoTemplate) {
    super(entityInformation, mongoTemplate);
  }

  @Override
  public Page<T> getByPaginator(Pageable pageable) {
    return findAll(pageable);
  }
}
