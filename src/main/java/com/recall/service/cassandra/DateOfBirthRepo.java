package com.recall.service.cassandra;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DateOfBirthRepo extends CrudRepository<DateOfBirthTable, NameKey> {
    @Query("SELECT * FROM datofbirthtable WHERE key =?0")
    List<DateOfBirthTable> findDateOfBirthByKey(String key);
}
