package br.com.ScreenMatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episode {
    private Integer seasonN;
    private LocalDate releaseDate;
    private String title;
    private Integer epNum;
    private Double rating;

    private Episode(Integer seasonN, EpData data ){
        this.seasonN=seasonN;
        this.title=data.title();
        this.epNum=data.epNum();

        try{
            this.releaseDate = LocalDate.parse(data.releaseDate());
        }catch (DateTimeException e){
            this.releaseDate=null;
        }

        try {
            this.rating = Double.valueOf(data.rate());
        } catch (NumberFormatException e) {
            this.rating=0.0;
        }
    }

    public Integer getSeasonN() {
        return seasonN;
    }

    public void setSeasonN(Integer seasonN) {
        this.seasonN = seasonN;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpNum() {
        return epNum;
    }

    public void setEpNum(Integer epNum) {
        this.epNum = epNum;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "seasonN=" + seasonN +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                ", epNum=" + epNum +
                ", rating=" + rating +
                '}';
    }
}
