import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerAbstractTest {

    @Test
    public void testNFLPlayerA() {
        PlayerA player = new NFLPlayerA("Patrick Mahomes", 30);

        assertEquals("Patrick Mahomes", player.getNameA());
        assertEquals(30, player.getStatsA());
        assertEquals("Football", player.getSportA());
    }

    @Test
    public void testNBAPlayerA() {
        PlayerA player = new NBAPlayerA("Stephen Curry", 25);

        assertEquals("Stephen Curry", player.getNameA());
        assertEquals(25, player.getStatsA());
        assertEquals("Basketball", player.getSportA());
    }
}