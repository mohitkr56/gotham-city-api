
package com.gotham.gotham_city_api;

import com.gotham.gotham_city_api.entity.Character;
import com.gotham.gotham_city_api.repository.CharacterRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CharacterRepository characterRepository;

    public DataInitializer(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void run(String... args) {

        if (characterRepository.count() == 0) {

            List<Character> characters = List.of(

                    // DC HEROES
                    new Character("Batman", "Bruce Wayne", "Gotham", "Hero"),
                    new Character("Superman", "Clark Kent", "Metropolis", "Hero"),
                    new Character("Wonder Woman", "Diana Prince", "Themyscira", "Hero"),
                    new Character("Flash", "Barry Allen", "Central City", "Hero"),
                    new Character("Aquaman", "Arthur Curry", "Atlantis", "Hero"),
                    new Character("Green Lantern", "Hal Jordan", "Coast City", "Hero"),
                    new Character("Shazam", "Billy Batson", "Philadelphia", "Hero"),
                    new Character("Robin", "Dick Grayson", "Gotham", "Hero"),

                    // MARVEL HEROES
                    new Character("Spider-Man", "Peter Parker", "New York", "Hero"),
                    new Character("Iron Man", "Tony Stark", "New York", "Hero"),
                    new Character("Captain America", "Steve Rogers", "Brooklyn", "Hero"),
                    new Character("Thor", "Thor Odinson", "Asgard", "Hero"),
                    new Character("Hulk", "Bruce Banner", "New York", "Hero"),
                    new Character("Black Panther", "T'Challa", "Wakanda", "Hero"),

                    // DC VILLAINS
                    new Character("Joker", "Unknown", "Gotham", "Villain"),
                    new Character("Lex Luthor", "Lex Luthor", "Metropolis", "Villain"),
                    new Character("Darkseid", "Uxas", "Apokolips", "Villain"),
                    new Character("Bane", "Unknown", "Gotham", "Villain"),

                    // MARVEL VILLAINS
                    new Character("Thanos", "Thanos", "Titan", "Villain"),
                    new Character("Green Goblin", "Norman Osborn", "New York", "Villain")

            );

            characterRepository.saveAll(characters);

            System.out.println("==================================");
            System.out.println("20 SUPERHEROES LOADED SUCCESSFULLY!");
            System.out.println("WELCOME TO SUPERHERO UNIVERSE!");
            System.out.println("==================================");
        }
    }
}
