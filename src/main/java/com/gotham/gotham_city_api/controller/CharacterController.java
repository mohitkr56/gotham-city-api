
package com.gotham.gotham_city_api.controller;

import com.gotham.gotham_city_api.entity.Character;
import com.gotham.gotham_city_api.service.CharacterService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    // Constructor Injection
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    // 1. Add Character
    @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return characterService.addCharacter(character);
    }

    // 2. Get All Characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    // 3. Get Character By ID
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    // 4. Update Character
    @PutMapping("/{id}")
    public Character updateCharacter(
            @PathVariable Long id,
            @RequestBody Character character) {
        return characterService.updateCharacter(id, character);
    }

    // 5. Delete Character
    @DeleteMapping("/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return "Character deleted successfully!";
    }
}
