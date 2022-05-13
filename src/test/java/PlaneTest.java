import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUS_A320);
    }

    @Test
    public void planeHasPlaneType(){
        assertEquals(PlaneType.AIRBUS_A320, plane.getPlaneType());
    }

    @Test
    public void planeHasCapacity(){
        assertEquals(8, plane.getCapacity());
    }

    @Test
    public void planeHasTotalWeight(){
        assertEquals(352, plane.getTotalWeight());
    }

}
