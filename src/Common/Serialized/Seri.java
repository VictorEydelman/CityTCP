package Common.Serialized;

import Common.interfase.Command;

import java.io.Serializable;

public class Seri implements Serializable {
    private Common.interfase.Command command;

    public Seri (Common.interfase.Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
