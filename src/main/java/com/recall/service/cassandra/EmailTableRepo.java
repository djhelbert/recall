package com.recall.service.cassandra;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailTableRepo extends CrudRepository<EmailTable, NameKey> {

    @Query("SELECT * FROM emailtable WHERE total > ?0")
    List<NameTable> findEmailTotalGreaterThan(int total);
}