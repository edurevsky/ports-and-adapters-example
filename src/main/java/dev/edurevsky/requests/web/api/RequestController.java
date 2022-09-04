package dev.edurevsky.requests.web.api;

import dev.edurevsky.requests.application.FindRequestByIdUseCase;
import dev.edurevsky.requests.application.SaveRequestUseCase;
import dev.edurevsky.requests.application.UpdateRequestUseCase;
import dev.edurevsky.requests.core.domain.Request;
import dev.edurevsky.requests.application.dtos.NewRequestDto;
import dev.edurevsky.requests.application.dtos.UpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/requests")
public class RequestController {

    private final SaveRequestUseCase saveRequestUseCase;
    private final FindRequestByIdUseCase findRequestByIdUseCase;
    private final UpdateRequestUseCase updateRequestUseCase;

    public RequestController(
            SaveRequestUseCase saveRequestUseCase,
            FindRequestByIdUseCase findRequestByIdUseCase,
            UpdateRequestUseCase updateRequestUseCase) {
        this.saveRequestUseCase = saveRequestUseCase;
        this.findRequestByIdUseCase = findRequestByIdUseCase;
        this.updateRequestUseCase = updateRequestUseCase;
    }

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody NewRequestDto request) {
        var ret = saveRequestUseCase.execute(request);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable("id") Long id, @RequestBody UpdateRequestDto request) {
        var ret = updateRequestUseCase.execute(id, request);
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> findById(@PathVariable("id") Long id) {
        Request request = findRequestByIdUseCase.execute(id);
        return ResponseEntity.ok(request);
    }
}
