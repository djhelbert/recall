package com.recall.service.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NameTableRepo extends CrudRepository<NameTable, String> {
    @Query(value = "SELECT * FROM nametable WHERE last=?0")
    List<NameTable> findNameByLast(String last);
}