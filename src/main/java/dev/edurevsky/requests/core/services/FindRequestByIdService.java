package dev.edurevsky.requests.core.services;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.FindRequestByIdPort;
import dev.edurevsky.requests.core.ports.FindRequestByIdServicePort;

public class FindRequestByIdService implements FindRequestByIdServicePort {

    private final FindRequestByIdPort findRequestByIdPort;

    public FindRequestByIdService(FindRequestByIdPort findRequestByIdPort) {
        this.findRequestByIdPort = findRequestByIdPort;
    }

    @Override
    public Request findById(Long id) {
        return findRequestByIdPort.findById(id);
    }
}
