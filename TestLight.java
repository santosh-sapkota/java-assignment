/**
 * Auto Generated Java Class.
 */
public class TestLight extends Light {
  
public static void main(String[] args) {

Light light1 = new Light();

light1.setBrightness(3); // setting high brightness

light1.setColor("yellow");

light1.setOn(true);

Light light2 = new Light();

light2.setBrightness(2); // setting medium brightness

light2.setColor("blue");

light2.setOn(false);

System.out.println(light1);

System.out.println(light2);

}
}
