import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest{

    FlightManager flightManager;
    Flight flight;
    Pilot pilot1;
    Pilot pilot2;
    CabinCrew cabinCrew1;
    CabinCrew cabinCrew2;
    CabinCrew cabinCrew3;
    ArrayList<CabinCrew> cabinCrewMembers;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        flightManager = new FlightManager();
        pilot1 = new Pilot("Maverick", FlightCrewRank.CAPTAIN, "FLY431");
        pilot2 = new Pilot("Goose", FlightCrewRank.FIRST_OFFICER, "FLY013");
        cabinCrew1 = new CabinCrew("Harry", FlightCrewRank.PURSER);
        cabinCrew2 = new CabinCrew("Jack", FlightCrewRank.FLIGHT_ATTENDANT);
        cabinCrew3 = new CabinCrew("Sarah", FlightCrewRank.FLIGHT_ATTENDANT);
        cabinCrewMembers = new ArrayList<>(Arrays.asList(cabinCrew1, cabinCrew2, cabinCrew3));
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(pilot1, pilot2, cabinCrewMembers, plane, "CON1132", "JFK", "EDI", "11:05");
        passenger1 = new Passenger("Gordon", 0);
        passenger2 = new Passenger("Ethan", 3);
        passenger3 = new Passenger("David", 1);

    }

    @Test
    public void canCheckBaggageWeightPerPassenger(){
        assertEquals(20, flightManager.baggageWeightPerPassenger(flight), 0.0);
    }

    @Test
    public void canCheckBaggageWeightBookedWhenFlightEmpty(){
        assertEquals(0, flightManager.baggageWeightBooked(flight), 0.0);
    }

    @Test
    public void canCheckBaggageWeightBookedWithPassengers(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        assertEquals(80, flightManager.baggageWeightBooked(flight), 0.0);
    }

    @Test
    public void canCheckRemainingAvailableBaggageWeightWhenFlightEmpty(){
        assertEquals(100, flightManager.baggageWeightRemaining(flight), 0.0);
    }

    @Test
    public void canCheckRemainingAvailableBaggageWeightWithPassengers(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(40, flightManager.baggageWeightRemaining(flight), 0.0);
    }
}
