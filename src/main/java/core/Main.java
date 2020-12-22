package core;

import commands.*;
import listeners.commandListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.RichPresence;
import util.SECRETS;
import util.STATIC;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException, InterruptedException {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);

        builder.setActivity(new Activity() {
            @Override
            public boolean isRich() {
                return false;
            }

            @Nullable
            @Override
            public RichPresence asRichPresence() {
                return null;
            }

            @Nonnull
            @Override
            public String getName() {
                return "" + STATIC.VERSION;
            }

            @Nullable
            @Override
            public String getUrl() {
                return null;
            }

            @Nonnull
            @Override
            public ActivityType getType() { return ActivityType.WATCHING;
            }

            @Nullable
            @Override
            public Timestamps getTimestamps() {
                return null;
            }

            @Nullable
            @Override
            public Emoji getEmoji() {
                return null;
            }
        });

        addListeners();
        addCommands();

        builder.build().awaitReady();

    }

    public static void addCommands () {

        //info
        commandHandler.commands.put("info", new info());
        commandHandler.commands.put("help", new info());

        //yavi
        commandHandler.commands.put("yavi", new yavi());
        commandHandler.commands.put("Yavi", new yavi());
        commandHandler.commands.put("yaviii", new yavi());
        commandHandler.commands.put("Yaviii", new yavi());

        //clear
        commandHandler.commands.put("Clear", new clear());
        commandHandler.commands.put("clear",new clear());

        //cmds
        commandHandler.commands.put("Cmds", new cmds());
        commandHandler.commands.put("cmds", new cmds());
        commandHandler.commands.put("Commands", new cmds());
        commandHandler.commands.put("commands", new cmds());

        //kick
        commandHandler.commands.put("kick", new kick());
        commandHandler.commands.put("Kick", new kick());

        //test
        commandHandler.commands.put("test", new test());

        //startup
        commandHandler.commands.put("start", new startup());
        commandHandler.commands.put("Start", new startup());

        //serverinfo
        commandHandler.commands.put("server-info", new server());
        commandHandler.commands.put("Server-info", new server());
        commandHandler.commands.put("server-Info", new server());
        commandHandler.commands.put("Server-Info", new server());
    }

    public static void addListeners() {

        builder.addEventListeners(new commandListener() );
    }

}