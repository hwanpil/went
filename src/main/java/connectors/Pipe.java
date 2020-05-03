package connectors;

import materials.Fluid;

public abstract class Pipe {
    Fluid upStream;
    Fluid downStream;
    double diameter;
    String wallMaterial;

    public Pipe(Fluid in, double diameter, String wallMaterial) {
        this.upStream = in;
        this.downStream = in;
        this.diameter = diameter;
        this.wallMaterial = wallMaterial;
    }
}
