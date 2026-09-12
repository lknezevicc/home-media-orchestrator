package hr.lknezevic.homemediaorchestrator.stage;

import hr.lknezevic.homemediaorchestrator.action.StageAction;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MovieStage implements Stage{
    @Override
    public StageAction handle(Update update) {
        return null;
    }
}
