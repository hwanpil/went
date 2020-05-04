package materials;

import java.util.Map;

public abstract class AbstractFluid implements Fluid{

    double temperature;
    double massFlowRate;
    double density;
    double pressure;
    Map<Chemical, Double> components;

    @Override
    public String toString() {
        return "Fluid properties: {" +
                "temperature=" + temperature +
                ", massFlowRate=" + massFlowRate +
                ", density=" + density +
                ", pressure=" + pressure +
                ", components=" + components +
                '}';
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public Fluid setTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    @Override
    public double getMassFlowRate() {
        return massFlowRate;
    }

    @Override
    public Fluid setMassFlowRate(double massFlowRate) {
        this.massFlowRate = massFlowRate;
        return this;
    }

    @Override
    public double getDensity() {
        return density;
    }

    @Override
    public Fluid setDensity(double density) {
        this.density = density;
        return this;
    }

    @Override
    public double getPressure() {
        return pressure;
    }

    @Override
    public Fluid setPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    @Override
    public Map<Chemical, Double> getComponents() {
        return components;
    }

    @Override
    public Fluid setComponents(Map<Chemical, Double> components) {
        this.components = components;
        return this;
    }
}
