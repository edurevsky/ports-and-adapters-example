package dev.edurevsky.requests.application;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.FindRequestByIdServicePort;

public class FindRequestByIdUseCase {

    private final FindRequestByIdServicePort findRequestByIdServicePort;

    public FindRequestByIdUseCase(FindRequestByIdServicePort findRequestByIdServicePort) {
        this.findRequestByIdServicePort = findRequestByIdServicePort;
    }

    public Request execute(Long id) {
        return findRequestByIdServicePort.findById(id);
    }
}
