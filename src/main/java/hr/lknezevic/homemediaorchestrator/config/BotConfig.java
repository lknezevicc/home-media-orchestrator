package hr.lknezevic.homemediaorchestrator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "bot")
public record BotConfig(
        String botToken,
        String botUsername,
        Long adminId,
        List<Long> allowedUsers
) {}
