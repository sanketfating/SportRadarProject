package scoreBoardRunner;
/*
    Developed this program using IntelliJ IDE.

    @Author : Sanket Fating

    Functionality :
        This is a program to display Football World Cup Score board.
        There are in memory teams provided in the system to start with the league matches.
        User can also add more teams which are not present in the existing list.
        After selecting 'Home' and 'Away' teams, user can start league matches.
        he can update the score and end/finish the match/matches.
        Accordingly, the complete statistics of the matches will be displayed.
*/
import manager.TeamManager;

public class ScoreBoardRunner {
    public static void main (String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("          Welcome to Football World Cup");
        System.out.println("-----------------------------------------------");
        new TeamManager();
    }
}
