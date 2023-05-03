package Common.src.main.java.Serialized;

import Common.src.main.java.interfase.Command;
import Server.src.main.java.Collections.StandardOfLiving;

import java.io.Serializable;

public class Seriobject implements Serializable {
    private Command command;
    private StandardOfLiving standard;

    public Seriobject (Command command, StandardOfLiving standard){
        this.command = command;
        this.standard = standard;
    }

    public Command getCommand(){
        return command;
    }

    public Object getStandard(){
        return standard;
    }
}
