import connectors.Junction;
import connectors.Tjunction2to1;
import equipments.Repository;
import equipments.Sensor;
import exceptions.ComponentConfigurationException;
import exceptions.TooManyConnectorsException;
import materials.SimpleFluid;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository one = new Repository(new SimpleFluid(100));
        Repository two = new Repository(new SimpleFluid(200));
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

        System.out.println(sensor.getFluid().getMassFlowRate());
    }
}
