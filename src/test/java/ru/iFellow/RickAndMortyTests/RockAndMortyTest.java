package ru.iFellow.RickAndMortyTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.character.Character;
import ru.iFellow.constants.CharacterStatus;
import ru.iFellow.steps.RickAndMortySteps;

import java.util.*;

public class RockAndMortyTest {

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    String charName = "Morty Smith";
    int lastEpisodeNumber;

    @Test
    @DisplayName("Запрос списка персонажей по имени Морти со статусом 'alive'")
    public void checkListCharNameAlive() {
        List<Map<String, Object>> list = rickAndMortySteps.getListCharByName(charName).getList("results");
        Set<Integer> fullEpisodeList = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> episodeList = (List<String>) list.get(i).get("episode");
            for (int j = 0; j < episodeList.size(); j++) {
                fullEpisodeList.add(Integer.parseInt(episodeList.get(j).substring(episodeList.get(j).lastIndexOf("/") + 1)));
            }
        }
        String lastEpisode = "https://rickandmortyapi.com/api/episode/" + Collections.max(fullEpisodeList);
        lastEpisodeNumber = Collections.max(fullEpisodeList);
        System.out.println(lastEpisode);

    }
}