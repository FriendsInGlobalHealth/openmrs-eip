package org.openmrs.sync.core.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.core.entity.light.OrderTypeLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class OrderTypeLightServiceTest {

    @Mock
    private OpenMrsRepository<OrderTypeLight> repository;

    private OrderTypeLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new OrderTypeLightService(repository);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        String uuid = "uuid";

        // When
        OrderTypeLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedCareSetting(), result);
    }

    private OrderTypeLight getExpectedCareSetting() {
        OrderTypeLight orderType = new OrderTypeLight();
        orderType.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        orderType.setCreator(1L);
        orderType.setName("[Default]");
        orderType.setJavaClassName("[Default]");
        return orderType;
    }
}
