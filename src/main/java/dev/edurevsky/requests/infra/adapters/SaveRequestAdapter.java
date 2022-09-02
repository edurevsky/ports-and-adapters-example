package dev.edurevsky.requests.infra.adapters;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.SaveRequestPort;
import dev.edurevsky.requests.infra.mappers.RequestEntityToRequestMapper;
import dev.edurevsky.requests.infra.mappers.RequestToRequestEntityMapper;
import dev.edurevsky.requests.infra.entities.RequestEntity;
import dev.edurevsky.requests.infra.repositories.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveRequestAdapter implements SaveRequestPort {

    private final RequestRepository requestRepository;
    private final RequestToRequestEntityMapper requestToRequestEntityMapper;
    private final RequestEntityToRequestMapper requestEntityToRequestMapper;

    public SaveRequestAdapter(RequestRepository requestRepository, RequestToRequestEntityMapper requestToRequestEntityMapper, RequestEntityToRequestMapper requestEntityToRequestMapper) {
        this.requestRepository = requestRepository;
        this.requestToRequestEntityMapper = requestToRequestEntityMapper;
        this.requestEntityToRequestMapper = requestEntityToRequestMapper;
    }

    @Override
    public Request saveRequest(Request request) {
        RequestEntity requestEntity = requestToRequestEntityMapper.map(request);
        RequestEntity persisted = requestRepository.save(requestEntity);
        return requestEntityToRequestMapper.map(persisted);
    }
}
