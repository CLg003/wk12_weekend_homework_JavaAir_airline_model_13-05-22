public class Passenger extends Person{

    private int numberOfBags;
    private Flight flight;

    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
        this.flight = null;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public Flight getFlight(){
        return flight;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }
}
