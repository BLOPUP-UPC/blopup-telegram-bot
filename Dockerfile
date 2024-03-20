FROM openjdk:17-jdk-slim

COPY build/libs/blopup.telegram.bot.jar blopup.telegram.bot.jar
ENV TELEGRAM_BOT_TOKEN=$TELEGRAM_BOT_TOKEN
EXPOSE 2000

CMD ["java", "-jar", "blopup.telegram.bot.jar"]
