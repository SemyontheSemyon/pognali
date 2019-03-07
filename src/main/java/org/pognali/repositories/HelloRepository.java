package org.pognali.repositories;

import org.springframework.data.repository.CrudRepository;
import org.pognali.models.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long> {

}
