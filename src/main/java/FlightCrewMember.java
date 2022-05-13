public class FlightCrewMember extends Person{

    private FlightCrewRank rank;

    public FlightCrewMember(String name, FlightCrewRank rank) {
        super(name);
        this.rank = rank;
    }

    public FlightCrewRank getRank() {
        return rank;
    }
}
