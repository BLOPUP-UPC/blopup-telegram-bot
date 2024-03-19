FROM openjdk:17-jdk-slim

RUN VERSION=$(gradle -q printVersion)
COPY blopup.telegram.bot-"$VERSION".jar blopup.telegram.bot.jar
ENV TELEGRAM_BOT_TOKEN=$TELEGRAM_BOT_TOKEN

CMD ["java", "-jar", "blopup.telegram.bot.jar"]
