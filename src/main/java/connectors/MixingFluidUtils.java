package connectors;

import materials.Fluid;
import materials.IdealSinglePhaseLiquid;

import java.util.List;

public class MixingFluidUtils {
    public static Fluid mixSimple(List<Fluid> in) {
        double total = 0;
        double temp = 0;
        double density = 0;
        double pressure = 0;
        for (Fluid i : in) {
            double cmp = i.getMassFlowRate();
            total += cmp;
            temp += i.getTemperature()*cmp;
            density += i.getDensity()*cmp;
            pressure += i.getPressure()*cmp;
        }
        return new IdealSinglePhaseLiquid()
                .setMassFlowRate(total)
                .setDensity(density/total)
                .setPressure(pressure/total)
                .setTemperature(temp/total)
                .setComponents(in.get(0).getComponents());
    }

    public static Fluid mix(List<Fluid> in) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public static Fluid splitSimple(Fluid in, int outletsNum) {
        double total = in.getMassFlowRate();
        return new IdealSinglePhaseLiquid()
                .setMassFlowRate(total/outletsNum)
                .setTemperature(in.getTemperature())
                .setPressure(in.getPressure())
                .setComponents(in.getComponents())
                .setDensity(in.getDensity());
    }


}
