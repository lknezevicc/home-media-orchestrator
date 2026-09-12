package hr.lknezevic.homemediaorchestrator.stage;

import hr.lknezevic.homemediaorchestrator.enums.BotRootCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StageManager {

    public Stage getStage(Update update) {
        BotRootCommand botRootCommand = BotRootCommand.findByCommand(update).orElse(null);

        return switch(botRootCommand) {
            case MOVIE -> new MovieStage();
            case null -> new IllegalCommandStage();
        }
    }
}
