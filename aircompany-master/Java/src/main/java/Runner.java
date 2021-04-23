import java.util.logging.Logger;

public class Runner {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        Airport airport = new Airport(Fleet.planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());

        logger.info(String.format("Military airport sorted by max distance: %s",militaryAirport.sortByMaxDistance().toString()));
        logger.info(String.format("Passenger airport sorted by max speed: %s",passengerAirport.sortByMaxSpeed().toString()));
        logger.info(String.format("Plane with max passenger capacity: %s",passengerAirport.getPassengerPlaneWithMaxPassengersCapacity().toString()));
    }

}
