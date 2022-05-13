public class CabinCrew extends FlightCrewMember{

    public CabinCrew(String name, FlightCrewRank rank){
        super(name, rank);
    }

    public String relayMessageToPassengers(String message){
        return message;
    }

}
