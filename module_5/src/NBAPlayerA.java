public class NBAPlayerA extends PlayerA {

    public NBAPlayerA(String name, int stats) {
        super(name, stats);
    }

    @Override
    public int getStatsA() {
        return stats;
    }

    @Override
    public String getSportA() {
        return "Basketball";
    }
}