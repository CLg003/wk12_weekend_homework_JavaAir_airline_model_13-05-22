import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
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
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    FlightManager flightManager;

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
        passenger1 = new Passenger("Gordon", 0);
        passenger2 = new Passenger("Ethan", 3);
        passenger3 = new Passenger("David", 1);
        passenger4 = new Passenger("Jim", 0);
        passenger5 = new Passenger("Fraser", 1);
        passenger6 = new Passenger("Andrew", 1);
        flightManager = new FlightManager();
    }

    @Test
    public void flightHasPilot1(){
        assertEquals(pilot1, flight.getPilot1());
    }

    @Test
    public void flightHasPilot2(){
        assertEquals(pilot2, flight.getPilot2());
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
        assertEquals(plane, flight.getPlane());
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
        assertEquals(LocalTime.parse("11:05"), flight.getDepartureTime());
    }

    @Test
    public void canCheckFlightCapacity(){
        assertEquals(5, flight.capacity());
    }

    @Test
    public void canCheckTotalWeightAvailable(){
        assertEquals(200, flight.totalWeightAvailable());
    }

    @Test
    public void canCheckNumberOfBookedPassengers(){
        assertEquals(0, flight.numberOfBookedPassengers());
    }

    @Test
    public void canCheckNumberOfBagsBooked(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        assertEquals(4, flight.numberOfBagsBooked());
    }

    @Test
    public void canReturnNumberOfAvailableSeatsWhenEmpty(){
        assertEquals(5, flight.numberOfAvailableSeats());
    }

    @Test
    public void canBookPassengerIfAvailableSeats(){
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.numberOfBookedPassengers());
        assertEquals(4, flight.numberOfAvailableSeats());
    }

    @Test
    public void cannotBookPassengerIfNoSeats(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flight.bookPassenger(passenger5);
        flight.bookPassenger(passenger6);
        assertEquals(5, flight.numberOfBookedPassengers());
        assertEquals(0, flight.numberOfAvailableSeats());
    }

    @Test
    public void canReturnNumberOfAvailableSeatsWhenPartFull(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(3, flight.numberOfAvailableSeats());
    }

    @Test
    public void canReturnNumberOfAvailableSeatsWhenCompletelyFull(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flight.bookPassenger(passenger5);
        assertEquals(0, flight.numberOfAvailableSeats());
    }

    @Test
    public void canAddFlightToBookedPassenger(){
        flight.bookPassenger(passenger1);
        assertEquals(flight, passenger1.getFlight());
    }

}
