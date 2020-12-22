
//info
package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmds implements Commands {

    EmbedBuilder error = new EmbedBuilder().setColor(Color.ORANGE).setFooter("BORDER RolePlay I Strict I BORDER AT TUNNEL");

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {



        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (args.length < 1) {
            event.getTextChannel().sendMessage(
                    error.setDescription("---------» **COMMANDS** «---------" +
                            "\n " +
                            "\n:regional_indicator_i: **INFO** :heavy_minus_sign: :screwdriver: **BOT Creator** " +
                            "\n*-info,-help* :heavy_minus_sign: *-yavi,-yaviii*" +
                            "\n " +
                            "\n:broom: **Clear** :heavy_minus_sign: :heavy_minus_sign: :card_index:  **Server Info** " +
                            "\n*-clear [2-100]* :heavy_minus_sign: *-server-info*" +
                            "\n " +
                            "\n-----------------------------").build()
            ).queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] '/cmds/commands' wurde ausgeführt");
    }

    @Override
    public String help() {
        return null;
    }
}
