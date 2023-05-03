package Common.src.main.java.Serialized;

import Common.src.main.java.interfase.Command;

import java.io.Serializable;

public class Seri implements Serializable {
    private Command command;

    public Seri (Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
