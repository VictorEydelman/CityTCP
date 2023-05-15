package Serialized;

import interfase.Command;

import java.io.Serializable;

public class SeriCombined implements Serializable {
    private Command command;
    private String[] creatCollection;
    private int id;

    public SeriCombined (Command command, String[] creatCollection, int id){
        this.command = command;
        this.creatCollection = creatCollection;
        this.id = id;
    }

    public Command getCommand(){
        return command;
    }

    public String[] getCreatCollection(){
        return creatCollection;
    }

    public int getId(){
        return id;
    }
}