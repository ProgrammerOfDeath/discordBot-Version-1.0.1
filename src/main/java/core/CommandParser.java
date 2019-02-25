package core;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.ArrayList;

public class CommandParser {

    public CommandContainer parse(String raw, MessageReceivedEvent event){

        String beheaded = raw.replaceFirst(STATIC.prefix, "");  //Anfangszeichen des Commands
        String[] splitBeheaded = beheaded.split(" ");               //Command Args aufteilen
        String invoke = splitBeheaded[0];                                 //Aus splitBeheaded Command-Invoke rauslesen

        //Aufgeteilten Command in ArrayList speichern (aus String-Array)
        ArrayList<String> split = new ArrayList<String>();
        for(String s: splitBeheaded){
            split.add(s);
        }

        //Jedes Arguments aus der ArrayList in String-Array packen, bis auf der die das Invoke
        String[] args = new String[split.size()-1];
        split.subList(1, split.size()).toArray(args);

        //Neues Klassenobjekt mit Parametern übergeben
        return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, event);
}

    public class CommandContainer {
        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public CommandContainer(String raw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = raw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }
    }

}
