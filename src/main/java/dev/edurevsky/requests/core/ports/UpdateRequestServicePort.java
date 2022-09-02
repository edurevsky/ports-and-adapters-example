package dev.edurevsky.requests.core.ports;

import dev.edurevsky.requests.core.domain.Request;

public interface UpdateRequestServicePort {

    Request update(Long id, String name, Boolean done);
}
