package com.recall.service.cassandra;

import org.springframework.data.repository.CrudRepository;

public interface AddressTableRepo extends CrudRepository<AddressTable, NameKey>  {
}
