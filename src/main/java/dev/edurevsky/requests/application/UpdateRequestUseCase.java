package dev.edurevsky.requests.application;

import dev.edurevsky.requests.application.dtos.UpdateRequestDto;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.UpdateRequestServicePort;

public class UpdateRequestUseCase {

    private final UpdateRequestServicePort updateRequestServicePort;

    public UpdateRequestUseCase(UpdateRequestServicePort updateRequestServicePort) {
        this.updateRequestServicePort = updateRequestServicePort;
    }

    public Request execute(Long id, UpdateRequestDto data) {
        return updateRequestServicePort.update(id, data.name(), data.done());
    }
}
