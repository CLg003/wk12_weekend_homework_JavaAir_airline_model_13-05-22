public class Pilot extends FlightCrewMember{

    private String pilotLicenceNumber;

    public Pilot (String name, FlightCrewRank rank, String pilotLicenceNumber){
        super(name, rank);
        this.pilotLicenceNumber = pilotLicenceNumber;
    }

    public String getPilotLicenceNumber() {
        return pilotLicenceNumber;
    }

    public String flyPlane(){
        return "Whooo!";
    }
}
