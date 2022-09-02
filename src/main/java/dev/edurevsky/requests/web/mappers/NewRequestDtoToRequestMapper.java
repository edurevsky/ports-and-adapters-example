package dev.edurevsky.requests.web.mappers;

import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.web.dtos.NewRequestDto;
import org.springframework.stereotype.Component;

@Component
public class NewRequestDtoToRequestMapper implements Mapper<NewRequestDto, Request> {

    @Override
    public Request map(NewRequestDto data) {
        Request request = new Request();
        request.setName(data.name());
        return request;
    }
}
