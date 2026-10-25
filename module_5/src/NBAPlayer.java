public class NBAPlayer implements Player {

    private String name;
    private int stats;

    public NBAPlayer(String name, int stats) {
        this.name = name;
        this.stats = stats;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStats() {
        return stats;
    }

    @Override
    public String getSport() {
        return "Basketball";
    }
}