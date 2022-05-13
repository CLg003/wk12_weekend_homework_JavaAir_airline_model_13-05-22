import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Maverick", FlightCrewRank.FIRST_OFFICER, "FLY127");
    }

    @Test
    public void pilotHasName(){
        assertEquals("Maverick", pilot.getName());
    }

    @Test
    public void pilotHasRank(){
        assertEquals(FlightCrewRank.FIRST_OFFICER, pilot.getRank());
    }

    @Test
    public void pilotHasPilotLicenceNumber(){
        assertEquals("FLY127", pilot.getPilotLicenceNumber());
    }

    @Test
    public void canFlyPlane(){
        String result = pilot.flyPlane();
        assertEquals("Whooo!", result);
    }
}
