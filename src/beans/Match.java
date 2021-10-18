package beans;

public class Match {
    private FootballTeam homeTeam;
    private FootballTeam awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    //Constructors
    public Match() {
    }

    public Match(FootballTeam homeTeam, FootballTeam awayTeam, int homeTeamScore, int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    //Methods
    public FootballTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String displayScore() {
        return homeTeam.getCountry()+" - "+awayTeam.getCountry()+" : "+homeTeamScore+" - "+awayTeamScore;
    }

    public String displayCompletedScore() {
        return homeTeam.getCountry() + " " + homeTeamScore + " - " + awayTeam.getCountry() + " " + awayTeamScore;
    }
}
