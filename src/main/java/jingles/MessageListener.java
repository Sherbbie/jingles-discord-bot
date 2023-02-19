package jingles;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.ArrayList;

public class MessageListener extends ListenerAdapter {

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    if (event.getAuthor().isBot()) return;

    if (event.isFromType(ChannelType.PRIVATE)) {
      System.out.printf("[PM] %s: %s\n",
              event.getAuthor().getName(),
              event.getMessage().getContentDisplay()
              );
    } else {
      System.out.printf("[%s][%s] %s: %s\n",
              event.getGuild().getName(),
              event.getChannel().getName(),
              event.getMember().getEffectiveName(),
              event.getMessage().getContentDisplay()
              );
    };


    String receivedText = event.getMessage().getContentDisplay();


    if (receivedText.contains("@Jingles")) {

      MessageChannel channel = event.getChannel();
      String message = new String();

      if (receivedText.contains("?") & receivedText.contains("or")) {
        Random randomizer = new Random();
        Pattern choicePattern = Pattern.compile("(([^ @?,])+)([,?]| or)");
        Matcher choiceFindings = choicePattern.matcher(receivedText);
        ArrayList<String> choices = new ArrayList<String>();

        while (choiceFindings.find()) {
          choices.add(choiceFindings.group());
        }

        if (choices.size() > 0) {
          String dirtyMessage = choices.get(randomizer.nextInt(choices.size()));
          message = dirtyMessage.replace(" or","").replace(",","").replace("?","");
        } else {
          message = "I don't know!";
        };
  
      } else {
        message = "Um.. yeah... ..do you have cheese?";
      };
            
      channel.sendMessage(message).queue();
      return;
    };
    
  };
};
