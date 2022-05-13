import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {

    CabinCrew cabinCrew;

    @Before
    public void before(){
        cabinCrew = new CabinCrew("Joey", FlightCrewRank.FLIGHT_ATTENDANT);
    }

    @Test
    public void cabinCrewHasName(){
        assertEquals("Joey", cabinCrew.getName());
    }

    @Test
    public void cabinCrewHasRank(){
        assertEquals(FlightCrewRank.FLIGHT_ATTENDANT, cabinCrew.getRank());
    }

    @Test
    public void flightAttendantCanRelayMessagesToPassengers(){
        String messageRelayed = cabinCrew.relayMessageToPassengers("Please return your seats to the upright position for landing.");
        assertEquals("Please return your seats to the upright position for landing.", messageRelayed);
    }
}
