package dev.edurevsky.requests.web.api;

import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.core.ports.SaveRequestServicePort;
import dev.edurevsky.requests.core.ports.UpdateRequestServicePort;
import dev.edurevsky.requests.core.services.FindRequestByIdService;
import dev.edurevsky.requests.commons.Mapper;
import dev.edurevsky.requests.web.dtos.NewRequestDto;
import dev.edurevsky.requests.web.dtos.UpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/requests")
public class RequestController {

    private final SaveRequestServicePort saveRequestServicePort;
    private final UpdateRequestServicePort updateRequestServicePort;
    private final FindRequestByIdService findRequestByIdService;
    private final Mapper<NewRequestDto, Request> newRequestDtoToRequestMapper;

    public RequestController(
            SaveRequestServicePort saveRequestServicePort,
            UpdateRequestServicePort updateRequestServicePort,
            FindRequestByIdService findRequestByIdService,
            Mapper<NewRequestDto, Request> newRequestDtoRequestMapper
    ) {
        this.saveRequestServicePort = saveRequestServicePort;
        this.updateRequestServicePort = updateRequestServicePort;
        this.findRequestByIdService = findRequestByIdService;
        this.newRequestDtoToRequestMapper = newRequestDtoRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody NewRequestDto requestDto) {
        Request request = newRequestDtoToRequestMapper.map(requestDto);
        var ret = saveRequestServicePort.save(request);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable("id") Long id, @RequestBody UpdateRequestDto updateRequestDto) {
        Request request = updateRequestServicePort.update(id, updateRequestDto.name(), updateRequestDto.done());
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> findById(@PathVariable("id") Long id) {
        Request request = findRequestByIdService.findById(id);
        return ResponseEntity.ok(request);
    }
}
