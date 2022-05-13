import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Pilot pilot1;
    Pilot pilot2;
    CabinCrew cabinCrew1;
    CabinCrew cabinCrew2;
    CabinCrew cabinCrew3;
    ArrayList<CabinCrew> cabinCrewMembers;
    Plane plane;

    @Before
    public void before(){
        pilot1 = new Pilot("Maverick", FlightCrewRank.CAPTAIN, "FLY431");
        pilot2 = new Pilot("Goose", FlightCrewRank.FIRST_OFFICER, "FLY013");
        cabinCrew1 = new CabinCrew("Harry", FlightCrewRank.PURSER);
        cabinCrew2 = new CabinCrew("Jack", FlightCrewRank.FLIGHT_ATTENDANT);
        cabinCrew3 = new CabinCrew("Sarah", FlightCrewRank.FLIGHT_ATTENDANT);
        cabinCrewMembers = new ArrayList<>(Arrays.asList(cabinCrew1, cabinCrew2, cabinCrew3));
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(pilot1, pilot2, cabinCrewMembers, plane, "CON1132", "JFK", "EDI", "11:05");
    }

    @Test
    public void flightHasTwoPilots(){
        assertEquals(2, flight.getPilots().size());
    }

    @Test
    public void flightHasThreeCabinCrew(){
        assertEquals(3, flight.getCabinCrewMembers().size());
    }

    @Test
    public void flightStartsWithZeroPassengers(){
        assertEquals(0, flight.getBookedPassengers().size());
    }

    @Test
    public void flightHasPlane(){
        assertEquals(PlaneType.CONCORDE, flight.getPlane().getPlaneType());
    }

    @Test
    public void flightHasFlightNumber(){
        assertEquals("CON1132", flight.getFlightNumber());
    }

    @Test
    public void flightHasDestinationAirport(){
        assertEquals("JFK", flight.getDestinationAirport());
    }

    @Test
    public void flightHasDepartureAirport(){
        assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void flightHasDepartureTime(){
        assertEquals("11:05", flight.getDepartureTime());
    }

    @Test
    public void canCheckFlightCapacity(){
        assertEquals(5, flight.capacity());
    }

    @Test
    public void canCheckNumberOfBookedPassengers(){
        assertEquals(0, flight.numberOfBookedPassengers());
    }

    @Test
    public void flightCanReturnNumberOfAvailableSeatsWhenEmpty(){
        assertEquals(5, flight.numberOfAvailableSeats());
    }

//    @Test
//    public void flightCanBookPassengersIfAvailableSeats(){
//
//    }
//
//    @Test
//    public void flightCannotBookPassengersIfNoSeats(){
//
//    }

//    @Test
//    public void flightCanReturnNumberOfAvailableSeatsWhenPartFull(){
//        assertEquals(3, flight.getNumberOfAvailableSeats());
//    }
//
//    @Test
//    public void flightCanReturnNumberOfAvailableSeatsWhenCompletelyFull(){
//        assertEquals(0, flight.getNumberOfAvailableSeats());
//    }


}
