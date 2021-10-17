package manager;

import beans.Match;
import beans.FootballTeam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeamManager implements TeamManagerInterface {

    private final ArrayList<FootballTeam> teams;
    private final Scanner scanner;
    private final ArrayList<Match> completedMatches;
    private final ArrayList<Match> liveMatches;

    //List.of("Mexico", "Canada", "Spain", "Brazil", "Germany", "France", "Uruguay", "Italy", "Argentina", "Australia"})
    public TeamManager() {
        this.teams = new ArrayList<FootballTeam>();
        this.scanner = new Scanner(System.in);
        this.completedMatches = new ArrayList<Match>();
        this.liveMatches = new ArrayList<Match>();
        List<String> countries = List.of("Mexico", "Canada", "Spain", "Brazil", "Germany",
                "France", "Uruguay", "Italy", "Argentina", "Australia");
        for (String country:countries) {
            FootballTeam footballTeam = new FootballTeam();
            footballTeam.setCountry(country);
            teams.add(footballTeam);
        }
        this.displayMenu();
    }

    @Override
    public void displayMenu() {
//        boolean condition1 = true;
        System.out.println("-----------------------------------------------");
        System.out.println("Press 1 to display available Teams ");
        System.out.println("Press 2 to add teams ");
        System.out.println("Press 3 to start league matches ");
        System.out.println("Press 4 to see live matches score ");
        System.out.println("Press 5 to see stats ");
        System.out.println("Press 6 to Finish the game ");
        System.out.println("-----------------------------------------------");

        String line = this.scanner.nextLine();
        int command = -1;
        try {
            command = Integer.parseInt(line);  //Get integer in the command line
        } catch (Exception var4) {
        }

        switch(command) {
            case 1:
                System.out.println("Available Teams : " + dispalyAllTeams());
                displayMenu();
                break;

            case 2:
                addTeam();
                addOtherTeam();
                break;

            case 3:
                startLeagueMatches();
                break;

            case 4:
                displayLiveMatchesScore();
                updateLiveAction();
                break;

            case 5:
                displayLiveMatchesScore();
                displayStats();
                displayMenu();
                break;

            case 6 :
                displayStats();
                break;

            default:
                System.out.println("Wrong Command. Please enter proper command");
        }
    }

    private String dispalyAllTeams() {
        if(teams.size() == 0){
            return "No Teams Available";
        }else{
            return teams.stream()
                    .map(x -> x.getCountry())
                    .collect(Collectors.joining(","));
        }
    }

    private void displayLiveMatchesScore() {
        System.out.println("Live Matches: " );
        for (int i=0; i<liveMatches.size(); i++) {
            //Match match = liveMatches.get(i);
            System.out.println("Match " + (i+1) + " : " + liveMatches.get(i).dispayScore());
        }

    }

    private void updateLiveAction() {
        System.out.println("-----------------------------------------------");
        System.out.println("Press 1 to update score ");
        System.out.println("Press 2 to end the game ");
        System.out.println("Press 3 to go back to main menu ");
        System.out.println("-----------------------------------------------");

        String line = this.scanner.nextLine();
        int command = -1;
        try {
            command = Integer.parseInt(line);  //Get integer in the command line
        } catch (Exception var4) {
        }

        switch(command) {
            case 1:
                displayLiveMatchesScore();
                updateCurrentMatchScore();
                break;

            case 2:
                displayLiveMatchesScore();
                endCurrentMatch();
                break;

            case 3:
                displayMenu();
                break;

            default:
                System.out.println("Wrong Command. Please enter proper command");
        }

    }

    private void endCurrentMatch() {
        System.out.println("Please select the match which will be ended");
        boolean condition = true;
        while(condition) {
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
            String line = this.scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line);  //Get integer in the command line
                if (command > 0 && command <= liveMatches.size()) {
                    Match match = liveMatches.get(command - 1);
                    System.out.println("Do you want to end this match? " + match.dispayScore());
                    System.out.println("Please enter 'Y' to confirm, else 'N'");
                    line = this.scanner.nextLine();
                    if (line.equalsIgnoreCase("Y")) {
                        completedMatches.add(match);
                        liveMatches.remove(match);
                        condition = false;
                        System.out.println("Match ended with final score" + match.dispayScore());
                        displayLiveMatchesScore();
                        //endCurrentMatch();
                        updateLiveAction();
                    } else if (line.equalsIgnoreCase("N")){
                        condition = false;
                        displayLiveMatchesScore();
                        //endCurrentMatch();
                        updateLiveAction();
                    } else {
                        System.out.println("Please enter 'Y' to confirm, else 'N'");
                    }
                }
            }
            catch (Exception var5) {
            }
        }
    }

    private void updateCurrentMatchScore() {
        System.out.println("Please enter match number from above list");
        boolean condition = true;
        while(condition) {
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
            String line = this.scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line);  //Get integer in the command line
                if (command > 0 && command <= liveMatches.size()) {
                    Match match = liveMatches.get(command-1);
                    System.out.println("Please enter Home - Away Team score eg. 1-3 ");
                    line = this.scanner.nextLine();
                    Integer homeScore = Integer.parseInt(line.split("-")[0].trim());
                    Integer awayScore = Integer.parseInt(line.split("-")[1].trim());
                    match.setHomeTeamScore(homeScore);
                    match.setAwayTeamScore(awayScore);
                    System.out.println("Updated score for Match " + command + " : " + match.dispayScore());
                    condition = false;
                    displayLiveMatchesScore();
                    updateLiveAction();
                }
            } catch (Exception var4) {
            }

        }
    }


    private void addTeam() {
        System.out.println("Please enter country name");
        FootballTeam footballTeam = new FootballTeam();
        String line = this.scanner.nextLine();
        footballTeam.setCountry(line);
        if (this.teams.contains(footballTeam)) {
            System.out.println("This team is already present");
        } else {
            this.teams.add(footballTeam);
            System.out.println("Available Teams : " + dispalyAllTeams());
        }
    }

    private void addOtherTeam(){
        boolean condition = true;
        while(condition) {
            System.out.println("Do you want to enter more teams ? (press Y/N)");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch (input) {
                case "Y":
                case "y":
                    addTeam();
                    break;
                case "N":
                case "n":
                    if(teams.size()%2 == 0){
                        condition = false;
                        displayMenu();
                    }else{
                        System.out.println("Teams Count : "+teams.size());
                        System.out.println("You must add one more team to start league stages");
                        addTeam();
                    }

                    break;
                default:
                    System.out.println("Wrong Command. Please enter 'Y' or 'N'");
            }
        }
    }

    private void startLeagueMatches() {
        FootballTeam home = getMatchTeam("Home", null);
        FootballTeam away = getMatchTeam("Away", home);

        Match match = new Match(home, away, 0, 0);
        liveMatches.add(match);

        System.out.println("Matches Started: " +  match.dispayScore());
        displayMenu();
    }

    public FootballTeam getMatchTeam(String type, FootballTeam home) {

        FootballTeam currentFootballTeam = null;

        boolean condition = true;
        while(condition) {
            System.out.println("Enter "+type+" Team Country Name");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();


            for (FootballTeam footballTeam: teams) {
                if(input.equalsIgnoreCase(footballTeam.getCountry())){
                    currentFootballTeam = footballTeam;
                }
            }

            if(currentFootballTeam == null){
                System.out.println("Please enter valid country from List :" + dispalyAllTeams());
            } else if(home != null && home.getCountry().equalsIgnoreCase(currentFootballTeam.getCountry())){
                System.out.println("Home And Away teams cannot be same");
            } else if (currentFootballTeam != null) {
                condition = false;
                return currentFootballTeam;
            }

        }

        return currentFootballTeam;
    }

//    @Override
    public void AddHomeAwayTeamsInputs() {



    }

//    @Override
    public void displayHomeTeamInputs() {
        System.out.println("Enter Home Team Country Name");
    }

//    @Override
    public void displayAwayTeamInputs() {
        System.out.println("Enter Away Team Country Name");
    }







//    @Override
    public void addHomeTeamScore() {

    }

//    @Override
    public void addAwayTeamScore() {

    }

//    @Override
    public void displayStats() {
        System.out.println("Completed Matches: " );
        completedMatches.sort((Match m1, Match m2)-> {
                    int result = ((m2.getHomeTeamScore() + m2.getAwayTeamScore())
                            - (m1.getHomeTeamScore() + m1.getAwayTeamScore()));
                    if (result == 0) {
                        return -1;
                    }
                    return result;
                }
        );

        for (int i=0; i<completedMatches.size(); i++) {
            //Match match = liveMatches.get(i);
            System.out.println(completedMatches.get(i).displayCompletedScore());
        }
    }

//    @Override
    public void endGame() {

    }
}
