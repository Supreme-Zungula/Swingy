package za.co.wethinkcode.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return ("X: " + this.getX() + " Y: " + this.getY());
    }
}