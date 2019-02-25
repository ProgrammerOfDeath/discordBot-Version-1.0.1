package core;

import commands.Commands;

import java.util.HashMap;

public class CommandHandler {

    public static final CommandParser parser = new CommandParser();

    //Festgelegte Commands in HashMap speichern
    public static HashMap<String, Commands> commands = new HashMap<String, Commands>();

    //Methode um mit Commands umzugehen
    public static void handleCommands(CommandParser.CommandContainer cmd){

        //Command erkennen
        if(commands.containsKey(cmd.invoke)){

            boolean right = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(!right){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(right, cmd.event);
            }else{
                commands.get(cmd.invoke).executed(right, cmd.event);
            }

        }
    }

}
