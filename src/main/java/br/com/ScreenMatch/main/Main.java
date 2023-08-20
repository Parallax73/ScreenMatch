package br.com.ScreenMatch.main;

import br.com.ScreenMatch.model.SeasonData;
import br.com.ScreenMatch.model.ShowData;
import br.com.ScreenMatch.service.ApiUsage;
import br.com.ScreenMatch.service.SerializeData;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private ApiUsage apiUsage = new ApiUsage();
    private SerializeData serializeData = new SerializeData();
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a6c449fa";

    public void showMenu() throws JsonProcessingException {
        System.out.println("Tv show name: ");
        var showName = sc.nextLine();
        var json = apiUsage.getData(URL + showName.replace(" ","+") + API_KEY);
        ShowData data = serializeData.getData(json, ShowData.class);
        System.out.println(data);

        	List<SeasonData> seasons = new ArrayList<>();
        	for (int i = 1; i<data.seasonN();i++){
                json = apiUsage.getData(URL + showName.replace(" ", "+") + "&season="+i+ API_KEY);
        		SeasonData seasonData = serializeData.getData(json, SeasonData.class);
        		seasons.add(seasonData);
        	}
        	seasons.forEach(System.out::println);

    }
}
