package dev.edurevsky.requests.core.ports;

import dev.edurevsky.requests.core.domain.Request;

public interface SaveRequestPort {

    Request saveRequest(Request request);
}
