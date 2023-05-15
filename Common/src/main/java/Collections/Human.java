package Collections;

import java.util.Date;

/**
 * Class Human
 */
public class Human {
    private final java.util.Date birthday;

    /**
     * Method for this to birthday
     * @param birthday birthday
     */
    public Human(java.util.Date birthday){
        this.birthday=birthday;
    }

    /**
     * Method for get birthday
     * @return birthday
     */
    public Date getBirthday(){
        return birthday;
    }
}
