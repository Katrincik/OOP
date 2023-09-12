public class InfoObject {
    private boolean moving;
    private int speed;
    private String color;

    public InfoObject(int speed, String color) {
        this.speed = speed;
        this.color = color;
        this.moving = speed>0;
    }

    public void printState() {
        System.out.println("Object's state:");
        System.out.println("Is the car moving? - " + moving);
        System.out.println("The speed is " + speed + " km/h" );
        System.out.println("The color is " + color);
    }

    public static void main(String[] args) {
        InfoObject Car = new InfoObject(60, "Black");
        Car.printState();
    }
}
