FROM gradle:jdk11-alpine AS BUILD_STAGE
COPY --chown=gradle:gradle . /home/gradle
RUN gradle build || return 1

FROM openjdk:11.0.11-jre
COPY --from=BUILD_STAGE /home/gradle/build/distributions/jingles-discord-bot.tar .
RUN tar xvf jingles-discord-bot.tar
ENTRYPOINT ["jingles-discord-bot/bin/jingles-discord-bot"]

# FROM openjdk:14-alpine
# COPY build/distributions/jingles-discord-bot.tar .
# RUN tar xvf jingles-discord-bot.tar
# ENTRYPOINT ["jingles-discord-bot/bin/jingles-discord-bot"]