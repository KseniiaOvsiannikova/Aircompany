import java.util.logging.Logger;

public class Runner {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        Airport airport = new Airport(Fleet.planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());
        logger.info("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        logger.info("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        logger.info("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
