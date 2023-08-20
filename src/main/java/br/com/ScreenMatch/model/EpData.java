package br.com.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpData(@JsonAlias("Title") String title, @JsonAlias("Episode") Integer epNum, @JsonAlias("imdbRating") String rate, @JsonAlias("Released") String releaseDate) {

}
