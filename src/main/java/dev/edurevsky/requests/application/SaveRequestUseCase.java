package dev.edurevsky.requests.application;

import dev.edurevsky.requests.application.dtos.NewRequestDto;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.SaveRequestServicePort;

public class SaveRequestUseCase {

    private final SaveRequestServicePort saveRequestServicePort;

    public SaveRequestUseCase(SaveRequestServicePort saveRequestServicePort) {
        this.saveRequestServicePort = saveRequestServicePort;
    }

    public Request execute(NewRequestDto data) {
        return saveRequestServicePort.save(data.toDomain());
    }
}
