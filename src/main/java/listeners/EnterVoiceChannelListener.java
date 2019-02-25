package listeners;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EnterVoiceChannelListener extends ListenerAdapter {
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        String entryMessage = "Ey jo, "+event.getVoiceState().getMember().getUser().getName()+" ist dem VoiceChannel "+event.getChannelJoined().getName()+" beigetreten";

        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(entryMessage).queue();

    }
}
