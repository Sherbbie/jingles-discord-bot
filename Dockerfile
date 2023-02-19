FROM openjdk:14-alpine
COPY build/distributions/jingles-discord-bot.tar .
RUN tar xvf jingles-discord-bot.tar
ENTRYPOINT ["jingles-discord-bot/bin/jingles-discord-bot"]