import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightCrewMemberTest {
    FlightCrewMember pilot;

    @Before
    public void before(){
        pilot = new FlightCrewMember("Sam", FlightCrewRank.CAPTAIN);
    }

    @Test
    public void flightCrewMemberHasName(){
        assertEquals("Sam", pilot.getName());
    }

    @Test
    public void flightCrewMemberHasRank(){
        assertEquals(FlightCrewRank.CAPTAIN, pilot.getRank());
    }
}
