package Serialized;

import Collections.StandardOfLiving;
import interfase.Command;

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
