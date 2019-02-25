package listeners;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EnterChannelListener extends ListenerAdapter {
    public void onGuildJoin(GuildJoinEvent event) {
        event.getGuild().getTextChannels().get(0).sendMessage("Hallo Fremder!").queue();
    }
}
