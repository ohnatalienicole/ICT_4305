public abstract class PlayerA {

    protected String name;
    protected int stats;

    public PlayerA(String name, int stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getNameA() {
        return name;
    }

    public abstract int getStatsA();

    public abstract String getSportA();
}