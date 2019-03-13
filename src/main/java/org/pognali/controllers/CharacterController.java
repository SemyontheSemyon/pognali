package org.pognali.controllers;

import org.pognali.models.Character;
import org.pognali.repositories.CharacterRepository;
import org.pognali.repositories.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("character/get")
    List<Character> getCharacters() {

        return (List)characterRepository.findAll();

    }

    @PostMapping("character/add/{helloId}")
    Character createCharacter(@PathVariable Long helloId,
                              @RequestBody Character character) {

        return helloRepository.findById(helloId)
                .map(hello -> {
                    character.setHello(hello);
                    return characterRepository.save(character);
                }).orElseThrow(RuntimeException::new);

    }

    @PostMapping("character/{characterId}/update/{helloId}")
    Character updateCharacter(@PathVariable Long characterId,
                              @PathVariable Long helloId,
                              @RequestBody Character characterRequest) {

        return characterRepository.findById(characterId)
                .map(character ->
                        helloRepository.findById(helloId)
                                .map(hello -> {
                                    character.setName(characterRequest.getName());
                                    character.setHello(hello);
                                    return characterRepository.save(character);
                                }).orElseThrow(RuntimeException::new)
                ).orElseThrow(RuntimeException::new);

    }

    @DeleteMapping("character/{characterId}/delete")
    ResponseEntity deleteCharacter(@PathVariable Long characterId) {

        return characterRepository.findById(characterId)
                .map(character -> {
                    characterRepository.delete(character);
                    return ResponseEntity.ok().build();
                }).orElseThrow(RuntimeException::new);

    }


}
