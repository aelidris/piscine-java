public class Excalibur {

    private static Excalibur instance;

    private String name;


    private Excalibur(String name) {
        this.name = name;
    }

    public static Excalibur getInstance() {
        if (instance == null) {
            instance = new Excalibur("Sword");
        }
        return instance;
    }

    public String getName() {
        return this.name;
    }
 
}
