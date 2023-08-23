package br.com.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Annotation to ignore every other data that are not called with the JsonAlias
public record ShowData(@JsonAlias("Title") String Title,@JsonAlias("totalSeasons") Integer Season,@JsonAlias("imdbRating") String Rate) {
    @Override
    public String toString() {
        return "Title: "+Title+"\nSeasons: "+ Season+"\nRating: "+Rate;
    }

    public String rTitle() {
        return Title;
    }
}
