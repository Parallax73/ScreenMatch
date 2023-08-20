package br.com.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Annotation to ignore every other data that are not called with the JsonAlias
public record ShowData(@JsonAlias("Title") String title,@JsonAlias("totalSeasons") Integer seasonN,@JsonAlias("imdbRating") String rate) {


}
