package listeners;

import core.CommandHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import util.STATIC;

public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if((event.getMessage().getContentRaw().startsWith(STATIC.prefix)) && (event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())){

            //Nachricht an CommandHandler übergeben und anschließend parsen
            CommandHandler.handleCommands(CommandHandler.parser.parse(event.getMessage().getContentRaw(), event));
        }
    }
}
