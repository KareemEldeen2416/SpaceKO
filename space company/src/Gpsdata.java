// Gpsdata class represents GPS data with destination information and coordinates
public class Gpsdata {
    // Private attributes specific to the Gpsdata class
    private String DestinationName;        // Name of the destination
    private  Float x_axis;               // x-axis coordinate
    private Float y_axis;             // y-axis coordinate

    // Constructor to initialize a Gpsdata object
    public Gpsdata(String destinationName,Float x_axis,Float y_axis){
        this.DestinationName=destinationName;
        this.x_axis=x_axis;
        this.y_axis=y_axis;
    }

    // Setter method for the DestinationName attribute
    public void setDestinationName(String DestinationName) {
        this.DestinationName = DestinationName;
    }

    public void setX_axis(Float x_axis) {
        this.x_axis = x_axis;
    }

    public void setY_axis(Float y_axis) {
        this.y_axis = y_axis;
    }

    // Getter method for the DestinationName attribute
    public String getDestinationName() {
        return DestinationName;
    }

    public Float getX_axis() {
        return x_axis;
    }

    public Float getY_axis() {
        return y_axis;
    }
}
