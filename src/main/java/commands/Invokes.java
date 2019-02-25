package commands;

import core.CommandHandler;

public class Invokes {
    public static void createCommandInvoke(){
        CommandHandler.commands.put("hilfe", new CmdHelp());
        CommandHandler.commands.put("moin", new CmdHello());
    }

    public static String[] getAllInvokes(){
        return CommandHandler.commands.keySet().toArray(new String[CommandHandler.commands.keySet().size()]);
    }
}
