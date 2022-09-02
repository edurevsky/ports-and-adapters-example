package dev.edurevsky.requests.infra.adapters;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.FindRequestByIdPort;
import dev.edurevsky.requests.infra.entities.RequestEntity;
import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.infra.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class FindRequestByIdAdapter implements FindRequestByIdPort {

    private final RequestRepository requestRepository;
    private final Mapper<RequestEntity, Request> requestEntityToRequestMapper;

    public FindRequestByIdAdapter(RequestRepository requestRepository, Mapper<RequestEntity, Request> requestEntityToRequestMapper) {
        this.requestRepository = requestRepository;
        this.requestEntityToRequestMapper = requestEntityToRequestMapper;
    }

    @Override
    public Request findById(Long id) {
        RequestEntity requestEntity = requestRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return requestEntityToRequestMapper.map(requestEntity);
    }
}
