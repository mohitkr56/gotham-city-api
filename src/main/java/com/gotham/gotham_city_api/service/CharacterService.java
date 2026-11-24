
package com.gotham.gotham_city_api.service;

import com.gotham.gotham_city_api.entity.Character;
import com.gotham.gotham_city_api.repository.CharacterRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    // Constructor Injection
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    // Add Character
    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    // Get All Characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Get Character By ID
    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    // Update Character
    public Character updateCharacter(Long id, Character updatedCharacter) {
        Character existingCharacter = characterRepository.findById(id).orElse(null);

        if (existingCharacter == null) {
            return null;
        }

        existingCharacter.setName(updatedCharacter.getName());
        existingCharacter.setRealName(updatedCharacter.getRealName());
        existingCharacter.setCity(updatedCharacter.getCity());
        existingCharacter.setRole(updatedCharacter.getRole());

        return characterRepository.save(existingCharacter);
    }

    // Delete Character
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
