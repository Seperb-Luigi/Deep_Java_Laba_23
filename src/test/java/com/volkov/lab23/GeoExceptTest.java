package com.volkov.lab23;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoExceptTest {
    private final GeoCalc calculator = new GeoCalc();

    @Test
    public void testCalculateCubeVolume_ValidInput() throws BaseGeoExcept {
        double result = calculator.calculateCubeVolume(3);
        assertEquals(27, result, 1e-6);
    }

    @Test
    public void testCalculateCubeVolume_InvalidInput() {
        assertThrows(ValidExcept.class, () -> calculator.calculateCubeVolume(-1));
    }

    @Test
    public void testCalculateSphereVolume_ValidInput() throws BaseGeoExcept {
        double result = calculator.calculateSphereVolume(2);
        assertEquals(33.5103, result, 1e-4);
    }

    @Test
    public void testCalculateSphereVolume_InvalidInput() {
        assertThrows(ValidExcept.class, () -> calculator.calculateSphereVolume(0));
    }

    @Test
    public void testCalculateCylinderVolume_ValidInput() throws BaseGeoExcept {
        double result = calculator.calculateCylinderVolume(2, 5);
        assertEquals(62.8318, result, 1e-4);
    }

    @Test
    public void testCalculateCylinderVolume_InvalidInput() {
        assertThrows(ValidExcept.class, () -> calculator.calculateCylinderVolume(-2, 5));
    }

    @Test
    public void testCalculateCylinderVolume_ExceedsLimit() {
        assertThrows(CalcExcept.class, () -> calculator.calculateCylinderVolume(500, 5000));
    }

    @Test
    public void testCalculateCubeVolume_ZeroInput() {
        assertThrows(ValidExcept.class, () -> calculator.calculateCubeVolume(0));
    }

    @Test
    public void testCalculateSphereVolume_LargeRadius() throws BaseGeoExcept {
        double result = calculator.calculateSphereVolume(1000);
        assertEquals((4.0 / 3.0) * Math.PI * Math.pow(1000, 3), result, 1e-6);
    }

    @Test
    public void testCalculateCylinderVolume_ZeroHeight() {
        assertThrows(ValidExcept.class, () -> calculator.calculateCylinderVolume(5, 0));
    }
}
