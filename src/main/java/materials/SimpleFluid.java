package materials;

import java.util.Map;

public class SimpleFluid implements Fluid{
    double temperature;
    double massFlowRate;
    double density;
    Map<Chemical, Double> chemicals;

    public SimpleFluid(double temperature, double massFlowRate, double density, Map<Chemical, Double> chemicals) {
        this.temperature = temperature;
        this.massFlowRate = massFlowRate;
        this.density = density;
        this.chemicals = chemicals;
    }

    public SimpleFluid(double temperature, double massFlowRate, double density) {
        this(temperature, massFlowRate, density, null);
    }

    public SimpleFluid(double massFlowRate) {
        this(25, massFlowRate, 1000, null);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMassFlowRate() {
        return massFlowRate;
    }

    public void setMassFlowRate(double massFlowRate) {
        this.massFlowRate = massFlowRate;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public Map<Chemical, Double> getChemicals() {
        return chemicals;
    }

    public void setChemicals(Map<Chemical, Double> chemicals) {
        this.chemicals = chemicals;
    }
}
