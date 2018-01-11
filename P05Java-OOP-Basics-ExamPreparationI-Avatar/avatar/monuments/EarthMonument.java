package avatar.monuments;

public class EarthMonument extends Monument{
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    public int getEarthAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("Earth Monument: %s, Earth Affinity: %d",
                super.getName(), this.getEarthAffinity());
    }

    @Override
    public int getPower() {
        return this.earthAffinity;
    }
}
