package dev.edurevsky.requests.web.mappers;

import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.web.dtos.UpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestDtoToRequestMapper implements Mapper<UpdateRequestDto, Request> {

    @Override
    public Request map(UpdateRequestDto data) {
        Request request = new Request();
        request.setName(data.name());
        request.setDone(data.done());
        return request;
    }
}
