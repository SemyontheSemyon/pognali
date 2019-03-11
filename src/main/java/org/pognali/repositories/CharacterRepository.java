package org.pognali.repositories;

import org.pognali.models.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Long> {
}
