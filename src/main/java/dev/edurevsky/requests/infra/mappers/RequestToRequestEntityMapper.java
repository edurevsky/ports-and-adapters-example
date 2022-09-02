package dev.edurevsky.requests.infra.mappers;

import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.infra.entities.RequestEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestToRequestEntityMapper implements Mapper<Request, RequestEntity> {

    @Override
    public RequestEntity map(Request data) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setId(data.getId());
        requestEntity.setName(data.getName());
        requestEntity.setDone(data.getDone());
        return requestEntity;
    }
}
