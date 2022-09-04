package dev.edurevsky.requests.application.dtos;

import dev.edurevsky.requests.core.domain.Request;

public record NewRequestDto(
    String name
) {
    public Request toDomain() {
        return new Request(null, name, null);
    }
}
