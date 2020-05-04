package materials;

import java.util.Map;

public interface Fluid {
    double getMassFlowRate();
    double getPressure();
    double getTemperature();
    double getDensity();
    Map<Chemical, Double> getComponents();
    Fluid setMassFlowRate(double massFlowRate);
    Fluid setTemperature(double temperature);
    Fluid setPressure(double pressure);
    Fluid setDensity(double density);
    Fluid setComponents(Map<Chemical, Double> components);
}
