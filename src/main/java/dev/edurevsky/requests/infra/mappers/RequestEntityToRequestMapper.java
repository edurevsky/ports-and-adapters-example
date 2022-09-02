package dev.edurevsky.requests.infra.mappers;

import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.infra.entities.RequestEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestEntityToRequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public Request map(RequestEntity data) {
        Request request = new Request();
        request.setId(data.getId());
        request.setName(data.getName());
        request.setDone(data.getDone());
        return request;
    }
}
