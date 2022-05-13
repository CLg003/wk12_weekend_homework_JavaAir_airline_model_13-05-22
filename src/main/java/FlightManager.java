public class FlightManager{

    public FlightManager(){}

    public double baggageWeightTotal(Flight flight){
        return flight.totalWeightAvailable() * 0.5;
    }

    public double baggageWeightPerPassenger(Flight flight){
        return baggageWeightTotal(flight) / flight.capacity();
    }

    public double baggageWeightBooked(Flight flight){
        return baggageWeightPerPassenger(flight) * flight.numberOfBagsBooked();
    }

    public double baggageWeightRemaining(Flight flight){
        return baggageWeightTotal(flight) - baggageWeightBooked(flight);
    }


}
