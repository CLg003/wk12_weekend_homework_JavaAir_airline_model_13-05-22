public class Passenger extends Person{

    private int numberOfBags;
    private Flight flight;
    private Integer seatNumber;

    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
        this.flight = null;
        this.seatNumber = null;
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

    public Integer getSeatNumber(){
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber){
        this.seatNumber = seatNumber;
    }
}
