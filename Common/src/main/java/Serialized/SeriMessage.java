package Serialized;

import java.io.Serializable;

public class SeriMessage implements Serializable {
    private String message;

    public SeriMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }
}
