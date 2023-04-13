package Common.Serialized;

import Common.interfase.Command;
import client.Commands.CreatCollection;

public class SeriCombined {
    private Command command;
    private CreatCollection creatCollection;
    private int id;

    public SeriCombined (Command command, CreatCollection creatCollection, int id){
        this.command = command;
        this.creatCollection = creatCollection;
        this.id = id;
    }

    public Command getCommand(){
        return command;
    }

    public CreatCollection getCreatCollection(){
        return creatCollection;
    }

    public int getId(){
        return id;
    }
}
