package jingles;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import java.util.Map;


public class Jingles {
  public static void main(String[] args) throws Exception{

    Map<String, String> environmentVariables = System.getenv();

    String token = environmentVariables.get("DISCORD_TOKEN");
    
    if (token == null) {
      throw new Exception("The DISCORD_TOKEN environment variable must contain a token.");
    };

    try {
      JDA api = JDABuilder.createDefault(token).addEventListeners(new MessageListener()).build().awaitReady();
    } catch (Exception e) {
      System.out.println("Could not log in due to error:");
      e.printStackTrace();
    }

  }
}