import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerInterfaceTest {

    @Test
    public void testNFLPlayer() {
        Player player = new NFLPlayer("Patrick Mahomes", 30);

        assertEquals("Patrick Mahomes", player.getName());
        assertEquals(30, player.getStats());
        assertEquals("Football", player.getSport());
    }

    @Test
    public void testNBAPlayer() {
        Player player = new NBAPlayer("Stephen Curry", 25);

        assertEquals("Stephen Curry", player.getName());
        assertEquals(25, player.getStats());
        assertEquals("Basketball", player.getSport());
    }
}