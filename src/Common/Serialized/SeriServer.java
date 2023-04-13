package Common.Serialized;

import Common.interfase.Command;

import java.io.Serializable;

public class SeriServer implements Serializable {
    private Command command;

    public SeriServer (Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
