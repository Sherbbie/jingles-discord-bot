package jingles;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import java.util.Map;


public class Jingles {
  public static void main(String[] args) throws Exception{

    Map<String, String> environmentVariables = System.getenv();

    String token = environmentVariables.get("DISCORD_TOKEN");
    String botName = environmentVariables.get("DISCORD_BOT_NAME");  
    
    assert token != null;
    assert botName != null;

    try {
      JDA api = JDABuilder.createDefault(token).addEventListeners(new MessageListener()).build().awaitReady();
    } catch (Exception e) {
      System.out.println("Could not log in due to error:");
      e.printStackTrace();
    }

  }
}