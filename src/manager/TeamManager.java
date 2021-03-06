package manager;

import beans.FootballTeam;
import beans.Match;
import java.util.ArrayList;
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
        System.out.println("-----------------------------------------------");
        System.out.println("Press 1 to display available Teams ");
        System.out.println("Press 2 to add teams ");
        System.out.println("Press 3 to start league matches ");
        System.out.println("Press 4 to see live matches score, update score and end the game ");
        System.out.println("Press 5 to see stats ");
        System.out.println("-----------------------------------------------");

        String line = this.scanner.nextLine();
        int command = -1;
        try {
            command = Integer.parseInt(line);  //Get integer in the command line
        } catch (Exception var1) {
        }

        switch(command) {
            case 1:
                System.out.println("Available Teams : " + distallyAllTeams());
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
                if (liveMatches.size() > 0) {
                    updateLiveAction();
                }else{
                    displayMenu();
                }
                break;

            case 5:
                displayLiveMatchesScore();
                displayStats();
                displayMenu();
                break;

            default:
                System.out.println("Wrong Command. Please enter proper command");
        }
    }

    private String distallyAllTeams() {
        if(teams.size() == 0){
            return "No Teams Available";
        }else{
            return teams.stream()
                    .map(x -> x.getCountry())
                    .collect(Collectors.joining(","));
        }
    }

    private void displayLiveMatchesScore() {
        if (liveMatches.size() > 0) {
            System.out.println("Live Matches: " );
            for (int i=0; i<liveMatches.size(); i++) {
                System.out.println("Match " + (i + 1) + " : " + liveMatches.get(i).displayScore());
            }
        } else {
            System.out.println("No Live Match Available " );
//            System.out.println("Displaying main menu again ");
  //          displayMenu();
        }
    }

    private void updateLiveAction() {
        System.out.println("-----------------------------------------------");
        System.out.println("Press 1 to update score ");
        System.out.println("Press 2 to end any one of the above games ");
        System.out.println("Press 3 to end all games ");
        System.out.println("Press 4 to go back to main menu ");
        System.out.println("-----------------------------------------------");

        String line = this.scanner.nextLine();
        int command = -1;
        try {
            command = Integer.parseInt(line);  //Get integer in the command line
        } catch (Exception var2) {
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
                endAllMatches();
                break;

            case 4:
                displayMenu();
                break;

            default:
                System.out.println("Wrong Command. Please enter proper command");
        }
    }

    private void endAllMatches() {
        boolean condition = true;
        while(condition) {
            try {
                    System.out.println("Do you want to end all matches? ");
                    System.out.println("Please enter 'Y' to confirm, else 'N' ");
                    String line = this.scanner.nextLine();
                    if (line.equalsIgnoreCase("Y")) {
                        for (int i=0; i < liveMatches.size(); i++) {
                            Match match = liveMatches.get(i);
                            completedMatches.add(match);
                        }
                        displayStats();
                        condition = false;
                    } else if (line.equalsIgnoreCase("N")){
                        condition = false;
                        displayLiveMatchesScore();
                        //endCurrentMatch();
                        updateLiveAction();
                    } else {
                        System.out.println("Please enter 'Y' to confirm, else 'N' ");
                    }
            }
            catch (Exception var3) {
            }
        }
    }

    private void endCurrentMatch() {
        System.out.println("Please select the match which will be ended ");
        boolean condition = true;
        while(condition) {
            String line = this.scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line);  //Get integer in the command line
                if (command > 0 && command <= liveMatches.size()) {
                    Match match = liveMatches.get(command - 1);
                    System.out.println("Do you want to end this match? " + match.displayScore());
                    System.out.println("Please enter 'Y' to confirm, else 'N' ");
                    line = this.scanner.nextLine();
                    if (line.equalsIgnoreCase("Y")) {
                        completedMatches.add(match);
                        liveMatches.remove(match);
                        condition = false;
                        System.out.println("Match ended with final score " + match.displayScore());
                        displayLiveMatchesScore();
                        //endCurrentMatch();
                        updateLiveAction();
                    } else if (line.equalsIgnoreCase("N")){
                        condition = false;
                        displayLiveMatchesScore();
                        //endCurrentMatch();
                        updateLiveAction();
                    } else {
                        System.out.println("Please enter 'Y' to confirm, else 'N' ");
                    }
                }
            }
            catch (Exception var4) {
            }
        }
    }

    private void updateCurrentMatchScore() {
        System.out.println("Please enter match number from above list ");
        boolean condition = true;
        while(condition) {
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
                    if (match.getHomeTeamScore() <= homeScore && match.getAwayTeamScore() <= awayScore) {
                        match.setHomeTeamScore(homeScore);
                        match.setAwayTeamScore(awayScore);
                        System.out.println("Updated score for Match " + command + " : " + match.displayScore());
                        condition = false;
                        displayLiveMatchesScore();
                        updateLiveAction();
                    } else {
                        if (match.getHomeTeamScore() > homeScore) {
                            System.out.println("Please enter home team score greater than or equal to " + match.getHomeTeamScore());
                        }
                        if (match.getAwayTeamScore() > awayScore) {
                            System.out.println("Please enter away team score greater than or equal to " + match.getAwayTeamScore());
                        }
                    }
                    validateUpdateCurrentScore(command, match, condition);
                }
            } catch (Exception var5) {
            }
        }
    }

    private void validateUpdateCurrentScore(int command, Match match, boolean condition) {
        String line = this.scanner.nextLine();
        Integer homeScore = Integer.parseInt(line.split("-")[0].trim());
        Integer awayScore = Integer.parseInt(line.split("-")[1].trim());
        if (match.getHomeTeamScore() <= homeScore && match.getAwayTeamScore() <= awayScore) {
            match.setHomeTeamScore(homeScore);
            match.setAwayTeamScore(awayScore);
            System.out.println("Updated score for Match " + command + " : " + match.displayScore());
            condition = false;
            displayLiveMatchesScore();
            updateLiveAction();
        } else {
            if (match.getHomeTeamScore() > homeScore) {
                System.out.println("Please enter home team score greater than or equal to " + match.getHomeTeamScore());
            }
            if (match.getAwayTeamScore() > awayScore) {
                System.out.println("Please enter away team score greater than or equal to " + match.getAwayTeamScore());
            }
        }
        validateUpdateCurrentScore(command, match, condition);
    }

    private void addTeam() {
        System.out.println("Please enter country name ");
        FootballTeam footballTeam = new FootballTeam();
        String line = this.scanner.nextLine();
        footballTeam.setCountry(line);
        if (this.teams.contains(footballTeam)) {
            System.out.println("This team is already present ");
        } else {
            this.teams.add(footballTeam);
            System.out.println("Available Teams : " + distallyAllTeams());
        }
    }

    private void addOtherTeam(){
        boolean condition = true;
        while(condition) {
            System.out.println("Do you want to enter more teams ? (press Y/N) ");
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
                        System.out.println("You must add one more team to start league stages ");
                        addTeam();
                    }
                    break;
                default:
                    System.out.println("Wrong Command. Please enter 'Y' or 'N' ");
            }
        }
    }

    private void startLeagueMatches() {
        FootballTeam home = getMatchTeam("Home", null);
        FootballTeam away = getMatchTeam("Away", home);
        Match match = new Match(home, away, 0, 0);
        liveMatches.add(match);
        System.out.println("Matches Started: " +  match.displayScore());
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
                System.out.println("Please enter valid country from List :" + distallyAllTeams());
            } else if(home != null && home.getCountry().equalsIgnoreCase(currentFootballTeam.getCountry())){
                System.out.println("Home And Away teams cannot be same ");
            } else if (currentFootballTeam != null) {
                condition = false;
                return currentFootballTeam;
            }
        }
        return currentFootballTeam;
    }
    //    @Override
    public void displayStats() {

        if(completedMatches.size()>0){
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
                System.out.println(completedMatches.get(i).displayCompletedScore());
            }
        } else{
            System.out.println("No Completed Match Available " );
        }
    }

}
