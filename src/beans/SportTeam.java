package beans;

public class SportTeam {
    //Properties
    private String name;
    private String statistics;

    //Constructors
    public SportTeam() {}  //No Argument Constructors

    public SportTeam(String name, String statistics) {
        this.name = name;
        this.statistics = statistics;
    } //All Arguments constructors

    //Methods
    public boolean equals(Object o) {
        return this.name.equals(((SportTeam)o).name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }
}

