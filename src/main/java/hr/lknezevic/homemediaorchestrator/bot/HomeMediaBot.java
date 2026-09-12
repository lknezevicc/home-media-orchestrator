package hr.lknezevic.homemediaorchestrator.bot;

import hr.lknezevic.homemediaorchestrator.config.BotConfig;
import hr.lknezevic.homemediaorchestrator.model.BotResponse;
import hr.lknezevic.homemediaorchestrator.stage.StageManager;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.BotSession;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.AfterBotRegistration;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class HomeMediaBot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {
    private final BotConfig botConfig;
    private final StageManager stageManager;
    private final TelegramClient telegramClient;

    public HomeMediaBot(BotConfig botConfig, StageManager stageManager) {
        this.botConfig = botConfig;
        this.stageManager = stageManager;
        this.telegramClient = new OkHttpTelegramClient(getBotToken());
    }

    @Override
    public String getBotToken() {
        return botConfig.botToken();
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        // TODO
        BotResponse response = stageManager.getStage(update)
                .handle(update)
                .getNextResponse();

        try {
            telegramClient.execute(SendMessage.builder().build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @AfterBotRegistration
    public void afterBotRegistration(BotSession botSession) throws TelegramApiException {
        System.out.println("Registered bot running state is: " + botSession.isRunning());
        telegramClient.execute(new SendMessage(botConfig.adminId().toString(), "Bot is online!"));
    }
}
