import connectors.Junction;
import equipments.Repository;
import equipments.Sensor;
import exceptions.ComponentConfigurationException;
import materials.Chemical;
import materials.CommonChemicals;
import materials.Fluid;
import materials.IdealSinglePhaseLiquid;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Chemical, Double> components = new HashMap<>();
        components.put(CommonChemicals.WATER, 1.0);
        Fluid first = new IdealSinglePhaseLiquid()
                .setTemperature(25)
                .setDensity(1000)
                .setMassFlowRate(100)
                .setPressure(1)
                .setComponents(components);
        Repository one = new Repository(first);
        Repository two = new Repository(first);
        Sensor sensor = new Sensor();
        Junction junction = Junction.of(2, 3);

        try {
            junction.to(sensor);
            one.to(junction);
            two.to(junction);
        } catch (ComponentConfigurationException e) {
            e.printStackTrace();
        }
        one.run();
        junction.run();
        sensor.run();

        System.out.println(sensor.getFluid());
    }
}
