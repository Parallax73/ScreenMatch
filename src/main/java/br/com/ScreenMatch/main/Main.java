package br.com.ScreenMatch.main;

import br.com.ScreenMatch.model.ShowData;
import br.com.ScreenMatch.service.ApiUsage;
import br.com.ScreenMatch.service.SerializeData;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;

public class Main {

    private final Scanner sc = new Scanner(System.in);
    private final ApiUsage apiUsage = new ApiUsage();
    private final SerializeData serializeData = new SerializeData();
    private final List<ShowData> watchLater = new ArrayList<>();
    private final Map<ShowData,Double> userRateList = new HashMap<>();


    public void showMenu() throws JsonProcessingException {

      loop:  while (true) {
            System.out.println("1 - Your lists\n2- Search for a Tv show or movie to add to your watchlist\n3- Rate a movie or Tv show\n0- Quit");
            var showName = sc.nextLine();
          String URL = "https://www.omdbapi.com/?t=";
          String API_KEY = "&apikey=a6c449fa";
          String nameT;
          String json;
          switch (showName){

                case "1":
                    System.out.println("1- Watch later list\n2- Rated movies");
                    String case1 = sc.nextLine();
                    nested_switch(case1);
                    break ;
                case "2":
                    System.out.println("Which Tv show or movie");
                    nameT = sc.nextLine();
                    json = apiUsage.getData(URL + nameT.replace(" ", "+") + API_KEY);
                    ShowData data = serializeData.getData(json, ShowData.class);
                    if (data.Title()==null||!nameT.equalsIgnoreCase(data.Title())) {
                        System.out.println(nameT +"doesn't exist or you may have written incorrectly");
                    } else {
                        watchLater.add(data);
                        System.out.println(data.Title() + " was added");
                    }
                    break ;

                case "3":
                    System.out.println("Name of the movie or Tv show you want to rate");
                    nameT = sc.nextLine();
                    json = apiUsage.getData(URL + nameT.replace(" ", "+") + API_KEY);
                    ShowData rateMovie = serializeData.getData(json, ShowData.class);
                    System.out.println("Your rate for: "+rateMovie.Title());
                    var userRate = Double.valueOf(sc.nextLine());
                    userRateList.put(rateMovie,userRate);
                    System.out.println(rateMovie.Title()+" was rated "+ userRate);
                    break;


                    case "0":
                    break loop;

                default:
                    System.out.println("Choose one of the options above:");
            break;
            }

        }
    }

    private void nested_switch(String c) {
        if (c.equals("1")){
            if (watchLater.size()>0) {
                watchLater
                        .forEach(s -> System.out.println(s.Title()));
            }
            System.out.println("Your list is empty");
        } else if (c.equals("2")) {
            if (userRateList.isEmpty()){
                System.out.println("Your list is empty");
            }
            for (ShowData rates: userRateList.keySet()){
                System.out.println(rates.rTitle()+"\nYour rating: "+ userRateList.get(rates));
            }
            }else {System.out.println("Wrong!!!! Try again");}
        }

}


