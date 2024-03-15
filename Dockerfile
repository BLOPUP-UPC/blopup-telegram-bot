FROM openjdk:17.0.1

COPY build/libs/blopup.telegram.bot-1.0.jar blopup.telegram.bot.jar
ENV TELEGRAM_BOT_TOKEN=$TELEGRAM_BOT_TOKEN

CMD ["java", "-jar", "blopup.telegram.bot.jar"]


