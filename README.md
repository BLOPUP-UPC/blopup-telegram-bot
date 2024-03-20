# blopup-telegram-bot

## Overview
This is a simple telegram bot that can be used to send messages to a telegram chat. It is written in Kotlin and uses the Kotlin Telegram Bot API.

## How to deploy
To deploy a new version of the bot, all you need to do is trigger the Github Actions workflow manually on the Github Actions page.
This will deploy the bot to the production server (blopup.upc.edu).

## How to use
This bot has two main purposes:
1. Return the chatid of the chat where the bot is being used. 
2. Send messages to the chat where the bot is being used. 

### Get chatid
1. In the Telegram app, add the bot to the chat where you want to send messages. The name of the bot is Blopup_bot.
2. Send the message `/chatid` to the chat. The bot will reply with the chatid of the user.

### Send messages
The Blopup App is automatically configured to send messages to a specific registered doctor. The chatid of the doctor is stored in the database. 
You can send messages to any chat through the Telegram Bot API by using the chat id.

See the [Blopup project documentation](https://blopup.atlassian.net/wiki/spaces/~639c5d7e61aba8a6a32d7565/pages/118685717/Changing+the+contact+of+the+Doctor+who+receives+messages+via+Telegram) for more information on how to update the chat id of the doctor currently receiving notifications via Telegram.

Here is a sample request to send a message to a given chatid:
````curl POST "https://api.telegram.org/bot<token>/sendMessage" -H 'Content-Type: application/json' -d '{"chat_id": "<chatid>", "text": "This is a test message"}'````
Replace `<token>` with the bot token and `<chatid>` with the chatid of the chat where you want to send the message.
The Bot Token is stored in the Blopup Bitwarden account.

See the [Telegram Bot API documentation](https://core.telegram.org/bots/api) for more information.
