package hr.lknezevic.homemediaorchestrator.stage;

import hr.lknezevic.homemediaorchestrator.action.StageAction;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Stage {
    StageAction handle(Update update);
}
