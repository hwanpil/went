import base.Factory;
import connectors.Junction;
import equipments.Repository;
import equipments.Sensor;
import exceptions.ComponentConfigurationException;
import factory.SimpleFactoryWithoutLoop;
import materials.Chemical;
import materials.CommonChemicals;
import materials.Fluid;
import materials.IdealSinglePhaseLiquid;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Factory f = new SimpleFactoryWithoutLoop();

        Map<Chemical, Double> components = new HashMap<>();
        components.put(CommonChemicals.WATER, 1.0);
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

        System.out.println(sensor.getFluid());
    }
}
