package org.openmrs.sync.core.service;

import org.openmrs.sync.core.entity.MockedEntity;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class AbstractSimpleServiceTest {

    @Mock
    private OpenMrsRepository<MockedEntity> repository;

    private MockedSimpleService service;

    private static final String UUID = "uuid";

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new MockedSimpleService(repository);
    }

    @Test
    public void getOrInit_exists() {
        // Given
        MockedEntity userEty = new MockedEntity(1L, UUID);
        when(repository.findByUuid(UUID)).thenReturn(userEty);
        when(repository.save(userEty)).thenReturn(userEty);

        // When
        MockedEntity result = service.getOrInit(UUID);

        // Then
        assertEquals(userEty, result);
    }

    @Test
    public void getOrInit_create() {
        // Given
        when(repository.findByUuid(UUID)).thenReturn(null);
        when(repository.save(new MockedEntity(null, UUID))).thenReturn(getExpectedEntity());

        // When
        MockedEntity result = service.getOrInit(UUID);

        // Then
        assertEquals(getExpectedEntity(), result);
    }

    private MockedEntity getExpectedEntity() {
        return new MockedEntity(1L, UUID);
    }
}
