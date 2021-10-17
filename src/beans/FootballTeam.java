package beans;

public class FootballTeam {
    //Properties
    private String country;

    //Constructors

    //Methods
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean equals(Object o) {
        return this.country.equals(((FootballTeam)o).country);
    }

}
