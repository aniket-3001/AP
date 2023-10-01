public class Earthquake {
    private String name;
    private double intensity;

    public Earthquake(String name, double intensity) throws IntensityException {
        this.name = name;
        
        if (intensity < 2.0 || intensity > 8.0) {
            throw new IntensityException("Invalid Intensity. Must be in the range of 2.0 to 8.0.");
        }
        else {
            this.intensity = intensity;
        }
    }

    public String toString() {
        return "Earthquake: " + name + "\nIntensity: " + intensity;
    }
}