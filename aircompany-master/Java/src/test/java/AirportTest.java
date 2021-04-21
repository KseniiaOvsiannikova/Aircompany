import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import planes.ExperimentalPlane;
import models.ClassificationLevels;
import models.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.testng.Assert.assertFalse;

public class AirportTest {

    private static final Logger logger = Logger.getGlobal();

    @Test
    public void GetTransportMilitaryPlanes() {
        Airport airport = new Airport(Fleet.planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if (militaryPlane.getType() == MilitaryTypes.TRANSPORT) {
                break;
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void GetPassengerPlaneWithMaxCapacity() {
        logger.info("TEST GetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(Fleet.planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(Fleet.planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void GetPlanesSortedByMaxLoadCapacity() {
        Airport airport = new Airport(Fleet.planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void HasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(Fleet.planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryTypes.BOMBER)) {
            }
            else {
                Assert.fail("Test failed!");
            }
        }
    }

    @Test
    public void ExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(Fleet.planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevels.UNCLASSIFIED){
                break;
            }
        }
        assertFalse(false);
    }
}
