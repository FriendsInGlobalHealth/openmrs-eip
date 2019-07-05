package org.openmrs.sync.core.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.core.entity.light.ProviderLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ProviderLightServiceTest {

    @Mock
    private OpenMrsRepository<ProviderLight> repository;

    private ProviderLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ProviderLightService(repository);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        String uuid = "uuid";

        // When
        ProviderLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedProvider(), result);
    }

    private ProviderLight getExpectedProvider() {
        ProviderLight provider = new ProviderLight();
        provider.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        provider.setCreator(1L);
        return provider;
    }
}
