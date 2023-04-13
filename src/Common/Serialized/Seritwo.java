package Common.Serialized;


import Common.interfase.Command;

import java.io.Serializable;

public class Seritwo implements Serializable {
    private Command command;
    private int key;

    public Seritwo (Command command, int key){
        this.command = command;
        this.key = key;
    }

    public Command getCommand(){
        return command;
    }

    public int getKey(){
        return key;
    }
}
