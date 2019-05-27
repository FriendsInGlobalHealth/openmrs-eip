package org.openmrs.sync.core.repository;

import org.openmrs.sync.core.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepository extends AuditableRepository<Person> {

    @Override
    Person findByUuid(final String uuid);

    @Override
    @Query("select p from Person p where p.dateChanged is null and p.dateCreated >= :lastSyncDate or p.dateChanged >= :lastSyncDate")
    List<Person> findModelsChangedAfterDate(@Param("lastSyncDate") LocalDateTime lastSyncDate);
}
