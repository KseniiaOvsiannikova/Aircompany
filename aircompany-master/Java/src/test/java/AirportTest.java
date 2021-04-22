import models.ClassificationLevels;
import models.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;
import java.util.logging.Logger;

public class AirportTest {

    private static final Logger logger = Logger.getGlobal();
    Airport airport = new Airport(Fleet.planes);

    @Test
    public void getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getType(), MilitaryTypes.TRANSPORT);
        }
    }

    @Test
    public void getPassengerPlaneWithMaxCapacity() {
        logger.info("TEST getPassengerPlaneWithMaxCapacity started!");
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(Fleet.planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void getPlanesSortedByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            Assert.assertFalse(currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertTrue(bomberMilitaryPlanes.size() > 0);
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            Assert.assertNotSame(experimentalPlane.getClassificationLevel() , ClassificationLevels.UNCLASSIFIED);
        }
    }
}
