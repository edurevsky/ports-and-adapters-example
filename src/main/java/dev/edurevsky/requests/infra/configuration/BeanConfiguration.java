package dev.edurevsky.requests.infra.configuration;

import dev.edurevsky.requests.core.services.FindRequestByIdService;
import dev.edurevsky.requests.core.services.SaveRequestService;
import dev.edurevsky.requests.core.services.UpdateRequestService;
import dev.edurevsky.requests.infra.adapters.FindRequestByIdAdapter;
import dev.edurevsky.requests.infra.adapters.SaveRequestAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public SaveRequestService saveRequestServicePort(SaveRequestAdapter saveRequestAdapter) {
        return new SaveRequestService(saveRequestAdapter);
    }

    @Bean
    public UpdateRequestService updateRequestService(FindRequestByIdAdapter findRequestByIdAdapter, SaveRequestAdapter saveRequestAdapter) {
        return new UpdateRequestService(findRequestByIdAdapter, saveRequestAdapter);
    }

    @Bean
    public FindRequestByIdService findRequestByIdService(FindRequestByIdAdapter findRequestByIdAdapter) {
        return new FindRequestByIdService(findRequestByIdAdapter);
    }
}
