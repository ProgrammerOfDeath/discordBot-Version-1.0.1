package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdHello implements Commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Moin, du geiler Mensch!").queue();
    }

    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("läuft");
    }

    public String help() {
        return null;
    }
}
