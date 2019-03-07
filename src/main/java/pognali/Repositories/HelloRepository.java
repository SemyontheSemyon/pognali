package pognali.Repositories;

import org.springframework.data.repository.CrudRepository;
import pognali.Models.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long> {

}
