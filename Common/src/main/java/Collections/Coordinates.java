package Collections;

/**
 * Class Coordinate
 */
public class Coordinates {
    private long x; //Максимальное значение поля: 735
    private Integer y; //Поле не может быть null

    /**
     * Method for this to x and y
     * @param x x
     * @param y y
     */
    public Coordinates(long x, Integer y){
        this.x=x;
        this.y=y;
    }

    /**
     * Method for get x
     * @return x
     */
    public long getX(){
        return x;
    }

    /**
     * Method for get y
     * @return y
     */
    public Integer getY(){
        return y;
    }
}
