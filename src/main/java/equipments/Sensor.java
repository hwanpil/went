package equipments;

import base.AbstractComponent;

public class Sensor extends AbstractComponent {

    public void run() {
        fluid = upStream.getFluid();
        // sensor won't do anything but give chance to access the fluid.
    }
}
