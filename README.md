# home-media-orchestrator

Work in progress: the skeleton of a Telegram bot meant to control a home media setup from chat. It is not functional yet and does not build in its current state.

## Idea

The bot receives messages through Telegram long polling and routes each one to a stage chosen from the root command (for example `/movie`). A stage handles the message and returns a response for the user.

## What exists

- Spring Boot application with `telegrambots-springboot-longpolling-starter`.
- `BotConfig` with the bot token, username, admin ID and allowed users (`bot.*` properties).
- `StageManager` that maps a command to a stage, with a `MovieStage` and an `IllegalCommandStage` as placeholders.
- The admin gets a "Bot is online!" message when the bot registers.

## What is missing

- The stages do not handle anything yet and the bot does not send real replies.
- `StageManager` and `IllegalCommandStage` do not compile.
- No media integration and no tests.

## Tech stack

Java 21, Spring Boot 4, Telegram Bots long polling, Lombok, Maven.
