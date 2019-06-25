package org.openmrs.sync.core.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.core.entity.light.ConceptClassLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ConceptClassLightServiceTest {

    @Mock
    private OpenMrsRepository<ConceptClassLight> repository;

    private ConceptClassLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ConceptClassLightService(repository);
    }

    @Test
    public void getShadowEntity() {
        // Given

        // When
        ConceptClassLight result = service.getShadowEntity("UUID");

        // Then
        assertEquals(getExpectedConceptClass(), result);
    }

    private ConceptClassLight getExpectedConceptClass() {
        ConceptClassLight conceptClass = new ConceptClassLight();
        conceptClass.setUuid("UUID");
        conceptClass.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        conceptClass.setCreator(1L);
        conceptClass.setName("[Default]");
        return conceptClass;
    }
}