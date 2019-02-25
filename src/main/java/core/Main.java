package core;


import commands.Invokes;
import listeners.CommandListener;
import listeners.EnterChannelListener;
import listeners.EnterVoiceChannelListener;
import listeners.readyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import util.TOKEN;

import javax.security.auth.login.LoginException;

import static commands.Invokes.createCommandInvoke;


public class Main {

    static JDABuilder jdaBuilder;

    public static void main(String[] Args){
        jdaBuilder = new JDABuilder(AccountType.BOT);

        jdaBuilder.setToken(TOKEN.token);  //Bot Token übergeben
        jdaBuilder.setAutoReconnect(true); //Falls Verbindung verloren geht
        jdaBuilder.setStatus(OnlineStatus.ONLINE); //Status des Bots

        initListener(); //Listener initalisieren

        createCommandInvoke();  //Commands abrufen

        //Bot laufen lassen
        try {
            JDA jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private static void initListener(){
        //Listener ---------------------------------------
        jdaBuilder.addEventListeners(new readyListener()); //Bot startet (Begrüßungstext)
        jdaBuilder.addEventListeners(new EnterChannelListener()); //Neuer Dude kommt rein
        jdaBuilder.addEventListeners(new EnterVoiceChannelListener()); //Neuer Dude kommt in den VoiceChannel
        jdaBuilder.addEventListeners(new CommandListener()); //Darauf achten, ob Nachricht einen Command enthält
        //-------- ---------------------------------------
    }
}
