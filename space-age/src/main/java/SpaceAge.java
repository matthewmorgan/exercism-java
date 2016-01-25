public class SpaceAge {
    private static final double earthSecondsPerYear = 31557600;
    private double seconds = 0;
    private double earthYears = 0;

    private enum PLANET {
        EARTH(1),
        MERCURY(.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private double f;

        PLANET(double factor) {
            this.f = factor;
        }
    }

    public SpaceAge(double seconds) {
        this.seconds = seconds;
        this.earthYears = this.seconds / earthSecondsPerYear;
    }

    public double getSeconds() {
        return this.seconds;
    }

    private double convert(double planet) {
        return earthYears / planet;
    }

    public double onEarth() {
        return convert(PLANET.EARTH.f);
    }

    public double onMercury() {
        return convert(PLANET.MERCURY.f);
    }

    public double onVenus() {
        return convert(PLANET.VENUS.f);
    }

    public double onMars() {
        return convert(PLANET.MARS.f);
    }

    public double onJupiter() {
        return convert(PLANET.JUPITER.f);
    }

    public double onSaturn() {
        return convert(PLANET.SATURN.f);
    }

    public double onUranus() {
        return convert(PLANET.URANUS.f);
    }

    public double onNeptune() {
        return convert(PLANET.NEPTUNE.f);
    }
}
