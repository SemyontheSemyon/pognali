package org.pognali.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.pognali.Models.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long> {

}
