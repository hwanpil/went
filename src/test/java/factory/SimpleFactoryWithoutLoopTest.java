package factory;

import base.Factory;
import connectors.Junction;
import equipments.Repository;
import equipments.Sensor;
import exceptions.ComponentConfigurationException;
import materials.Chemical;
import materials.CommonChemicals;
import materials.Fluid;
import materials.IdealSinglePhaseLiquid;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleFactoryWithoutLoopTest {
    @Test
    public void integratedTestForFactory(){
        Factory f = new SimpleFactoryWithoutLoop();

        Map<Chemical, Double> components = new HashMap<>();
        Chemical octane = CommonChemicals.OCTANE;
        components.put(octane, 1.0);
        System.out.println(octane.getPc().toString()+octane.getVc().toString()+octane.getTc().toString());
        assertNotNull(octane.getPc());
        Fluid first = new IdealSinglePhaseLiquid()
                .setTemperature(25)
                .setDensity(1000)
                .setMassFlowRate(100)
                .setPressure(1)
                .setComponents(components);
        Fluid sec = new IdealSinglePhaseLiquid()
                .setTemperature(45)
                .setDensity(1000)
                .setMassFlowRate(100)
                .setPressure(1)
                .setComponents(components);
        Repository one = new Repository(first);
        Repository two = new Repository(sec);
        Sensor sensor = new Sensor();
        Junction junction = Junction.of(2, 2);

        try {
            f.addEdge(two, junction);
            f.addEdge(junction, sensor);
            f.addEdge(one, junction);

        } catch (ComponentConfigurationException e) {
            e.printStackTrace();
        }

        f.run();

        assertNotNull(sensor.getFluid());
        assertEquals(sensor.getFluid().getComponents().keySet().size(), 1);

    }

}