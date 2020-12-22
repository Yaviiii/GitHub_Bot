package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class kick implements Commands {

    EmbedBuilder embedBuilder = new EmbedBuilder().setColor(Color.RED);

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        TextChannel textChannel = event.getTextChannel();
        List<Member> members = event.getMessage().getMentionedMembers();
        Member toKick = members.get(0);
        Member member = event.getMember();
        if (member.hasPermission(Permission.KICK_MEMBERS)) {

            if (args.length == 1) {

                toKick.kick();

                textChannel.sendMessage(
                        embedBuilder.setTitle("Kick")
                                .setDescription("User » **" + toKick.getUser().getName() + "** \n From » **" + member.getUser().getName() + "** \n Reason » **" + "Kein Grund angegeben" + "**")
                                .setFooter("Yaviii | BOTS")
                                .build()
                ).queue();

            } else if (args.length == 2) {

                toKick.kick(args[1]).queue();

                textChannel.sendMessage(
                        embedBuilder.setTitle("Kick")
                                .setDescription("User » **" + toKick.getUser().getName() + "** \n From » **" + member.getUser().getName() + "** \n Reason » **" + args[1] + "**")
                                .setFooter("Yaviii | BOTS")
                                .build()
                ).queue();
            }

        } else {
            textChannel.sendMessage("Du hast nicht genügend Berechtigungen!").queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.println("Der Befehl !kick wurde ausgeführt!");
    }

    @Override
    public String help() {
        return null;
    }
}
