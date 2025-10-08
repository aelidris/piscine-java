public class Car implements Transport {
    @Override
    public int getDistance(){
        return 600;
    }
//   +getDistance() int
}






// Driver <|-- CarDriver
// Driver <|-- PlaneDriver
// Transport <|-- Car
// Transport <|-- Plane