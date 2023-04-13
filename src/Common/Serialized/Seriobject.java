package Common.Serialized;

import Common.interfase.Command;
import Server.Collections.StandardOfLiving;

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

    public StandardOfLiving getStandard(){
        return standard;
    }
}
