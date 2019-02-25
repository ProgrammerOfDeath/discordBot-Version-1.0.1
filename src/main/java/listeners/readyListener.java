package listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String entry = "Moin Leute, bin hart am Start!";

        for(Guild g: event.getJDA().getGuilds() ){
            g.getTextChannels().get(0).sendMessage(entry).queue();
        }

    }

}
