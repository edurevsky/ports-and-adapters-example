package dev.edurevsky.requests.core.services;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.SaveRequestPort;
import dev.edurevsky.requests.core.ports.SaveRequestServicePort;

public class SaveRequestService implements SaveRequestServicePort {

    private final SaveRequestPort saveRequestPort;

    public SaveRequestService(SaveRequestPort saveRequestPort) {
        this.saveRequestPort = saveRequestPort;
    }

    @Override
    public Request save(Request request) {
        request.setDone(false);
        return saveRequestPort.saveRequest(request);
    }
}
