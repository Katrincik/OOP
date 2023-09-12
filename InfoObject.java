public class InfoObject {
    private boolean moving;
    private int speed;
    private String color;

    public InfoObject(boolean moving, int speed, String color) {
        this.moving = moving;
        this.speed = speed;
        this.color = color;
    }

    public void printState() {
        System.out.println("Object's state:");
        System.out.println("Is the car moving? - " + moving);
        System.out.println("The speed is " + speed + " km/h" );
        System.out.println("The color is " + color);
    }

    public static void main(String[] args) {
        InfoObject Car = new InfoObject(true, 60, "Black");
        Car.printState();
    }
}
