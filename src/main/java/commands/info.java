
//info
package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class info implements Commands {

    EmbedBuilder error = new EmbedBuilder().setColor(Color.ORANGE).setFooter("BORDER RolePlay I Strict I BORDER AT TUNNEL");

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {



        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (args.length < 1) {
            event.getTextChannel().sendMessage(
                    error.setDescription("---------» **INFO** «---------" +
                            "\n " +
                            "\n*Text* " +
                            "\n**My Prefix » ** *'* **-** *'* " +
                            "\n " +
                            "\n---------------------------- " +
                            "\n***All Commands*** " +
                            "\n " +
                            "\n**:card_box: Commands** " +
                            "\n*-commands,-cmds* " +
                            "\n " +
                            "\n-----------------------------").build()
            ).queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] '/help/info' wurde ausgeführt");
    }

    @Override
    public String help() {
        return null;
    }
}
