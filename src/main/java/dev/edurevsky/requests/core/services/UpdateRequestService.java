package dev.edurevsky.requests.core.services;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.FindRequestByIdPort;
import dev.edurevsky.requests.core.ports.SaveRequestPort;
import dev.edurevsky.requests.core.ports.UpdateRequestServicePort;

public class UpdateRequestService implements UpdateRequestServicePort {

    private final FindRequestByIdPort findRequestByIdPort;
    private final SaveRequestPort saveRequestPort;

    public UpdateRequestService(FindRequestByIdPort findRequestByIdPort, SaveRequestPort saveRequestPort) {
        this.findRequestByIdPort = findRequestByIdPort;
        this.saveRequestPort = saveRequestPort;
    }

    @Override
    public Request update(Long id, String name, Boolean done) {
        Request toUpdate = findRequestByIdPort.findById(id);
        toUpdate.update(name, done);
        return saveRequestPort.saveRequest(toUpdate);
    }
}
