package hr.lknezevic.homemediaorchestrator.util;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

@UtilityClass
public class UpdateUtil {

    public static boolean updateHasTextMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }
}
