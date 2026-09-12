package hr.lknezevic.homemediaorchestrator.action;

import hr.lknezevic.homemediaorchestrator.model.BotResponse;

public interface StageAction {
    BotResponse getNextResponse();
}
