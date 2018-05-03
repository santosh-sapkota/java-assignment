public class Light {
private static final int LOW = 1;
private static final int MEDIUM = 2;

private static final int HIGH = 3;

private int brightness;

private boolean on;

private String color;

/*

* Default constructor setting default values

*/

public Light() {

this.brightness = LOW;

this.on = false;

this.color = "red";

}

public int getBrightness() {

return brightness;

}

public void setBrightness(int brightness) {

if (brightness == 1)

this.brightness = LOW;

else if (brightness == 2)

this.brightness = MEDIUM;

else if (brightness == 3)

this.brightness = HIGH;

}

public boolean isOn() {

return on;

}

public void setOn(boolean on) {

this.on = on;

}

public String getColor() {

return color;

}

public void setColor(String color) {

this.color = color;

}

@Override

public String toString() {

String bright = "";

if (brightness == 1)

bright = "LOW";

else if (brightness == 2)

bright = "MEDIUM";

else if (brightness == 3)

bright = "HIGH";

if (on) {

return "brightness: " + bright + " color: " + color;

} else {

return "color: " + color + " and light is off";

}

}

}
