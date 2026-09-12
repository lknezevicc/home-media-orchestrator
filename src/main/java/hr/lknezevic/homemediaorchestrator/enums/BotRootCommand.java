package hr.lknezevic.homemediaorchestrator.enums;

import hr.lknezevic.homemediaorchestrator.util.UpdateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum BotRootCommand {
    MOVIE("/movie"),
    ILLEGAL("");

    private final String command;

    public static Optional<BotRootCommand> findByCommand(Update update) {
        if (UpdateUtil.updateHasTextMessage(update)) {
            String message = update.getMessage().getText();

            return Arrays.stream(values())
                    .filter(cmd -> message.startsWith(cmd.command))
                    .findFirst();
        }

        return Optional.empty();
    }
}
