import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Flight {

    private Pilot pilot1;
    private Pilot pilot2;
    private ArrayList<CabinCrew> cabinCrewMembers;
    private ArrayList<Passenger> bookedPassengers;
    private Plane plane;
    private String flightNumber;
    private String destinationAirport;
    private String departureAirport;
    private LocalTime departureTime;

    public Flight(Pilot pilot1, Pilot pilot2, ArrayList<CabinCrew> cabinCrewMembers, Plane plane, String flightNumber, String destinationAirport, String departureAirport, String departureTime){
        this.pilot1 = pilot1;
        this.pilot2 = pilot2;
        this.cabinCrewMembers = cabinCrewMembers;
        this.bookedPassengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = LocalTime.parse(departureTime);
    }

    public Pilot getPilot1() {
        return pilot1;
    }

    public Pilot getPilot2() {
        return pilot2;
    }

    public ArrayList<Pilot> getPilots(){
        ArrayList<Pilot> pilots = new ArrayList<>();
        Collections.addAll(pilots, pilot1, pilot2);
        return pilots;
    }

    public ArrayList<CabinCrew> getCabinCrewMembers() {
        return cabinCrewMembers;
    }

    public ArrayList<Passenger> getBookedPassengers() {
        return bookedPassengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int capacity(){
        return plane.getCapacity();
    }

    public int totalWeightAvailable(){
        return plane.getTotalWeight();
    }

    public int numberOfBookedPassengers(){
        return bookedPassengers.size();
    }

    public int numberOfBagsBooked(){
        int totalBags = 0;
        for (Passenger passenger : bookedPassengers) {
            totalBags += passenger.getNumberOfBags();
        }
        return totalBags;
    }

    public int numberOfAvailableSeats(){
        return capacity() - numberOfBookedPassengers();
    }

    public void bookPassenger(Passenger passenger){
        if (numberOfAvailableSeats() > 0) {
            bookedPassengers.add(passenger);
        }
    }
}
