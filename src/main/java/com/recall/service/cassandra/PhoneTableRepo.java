package com.recall.service.cassandra;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneTableRepo extends CrudRepository<PhoneTable, NameKey>  {
    @Query("SELECT * FROM phonetable WHERE key =?0")
    List<NameTable> findPhoneByKey(String key);
}
