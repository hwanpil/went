import base.Resource;
import connectors.Tjunction2to1;
import equipments.Repository;
import equipments.Sensor;
import materials.SimpleFluid;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository one = new Repository(new SimpleFluid(100));
        Repository two = new Repository(new SimpleFluid(200));
        Sensor sensor = new Sensor();
        Tjunction2to1 tjunction2to1 = new Tjunction2to1();
        one.to(tjunction2to1);
        two.to(tjunction2to1);
        tjunction2to1.to(sensor);

        tjunction2to1.run();

        System.out.println(sensor.getFluid().getMassFlowRate());
    }
}
