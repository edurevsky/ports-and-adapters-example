package dev.edurevsky.requests.core.ports;

import dev.edurevsky.requests.core.domain.Request;

public interface SaveRequestServicePort {

    Request save(Request request);
}
