package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

import static commands.Invokes.*;

public class CmdHelp implements Commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        String[] allInvokes = getAllInvokes();

        event.getTextChannel().sendMessage("Versuche diese Befehle: "+ Arrays.toString(allInvokes)).queue();
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
