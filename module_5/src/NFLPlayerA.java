public class NFLPlayerA extends PlayerA {

    public NFLPlayerA(String name, int stats) {
        super(name, stats);
    }

    @Override
    public int getStatsA() {
        return stats;
    }

    @Override
    public String getSportA() {
        return "Football";
    }
}