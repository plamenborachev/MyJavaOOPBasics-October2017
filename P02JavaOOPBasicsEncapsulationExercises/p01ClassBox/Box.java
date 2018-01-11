package p01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;
    private double surfaceArea;
    private double lateralSurfaceArea;
    private double volume;

    public Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double setSurfaceArea(){
        return 2 * (this.length * this.width + this.length * this.height + this.width * this.height);
    }

    public double setLateralSurfaceArea(){
        return 2 * (this.length * this.height + this.width * this.height);
    }

    public double setVolume() {
        return this.length * this.width * this.height;
    }
}
