package connectors;

import materials.Fluid;
import materials.SimpleFluid;

import java.util.List;

public class MixingFluidUtils {
    public static Fluid mixSimple(List<Fluid> in) {
        double total = 0;
        for (Fluid i : in) {
            total += i.getMassFlowRate();
        }
        return new SimpleFluid(total);
    }
}
