package org.openmrs.sync.core.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.core.entity.light.ConceptLight;
import org.openmrs.sync.core.entity.light.ProgramWorkflowLight;
import org.openmrs.sync.core.entity.light.ProgramWorkflowStateLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.openmrs.sync.core.service.light.LightService;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProgramWorkflowStateLightServiceTest {

    @Mock
    private OpenMrsRepository<ProgramWorkflowStateLight> repository;

    @Mock
    private LightService<ConceptLight> conceptService;

    @Mock
    private LightService<ProgramWorkflowLight> programWorkflowService;

    private ProgramWorkflowStateLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ProgramWorkflowStateLightService(repository, conceptService, programWorkflowService);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        when(conceptService.getOrInitPlaceholderEntity()).thenReturn(getConcept());
        when(programWorkflowService.getOrInitPlaceholderEntity()).thenReturn(getProgramWorkflow());
        String uuid = "uuid";

        // When
        ProgramWorkflowStateLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedProgramWorkflow(), result);
    }

    private ProgramWorkflowStateLight getExpectedProgramWorkflow() {
        ProgramWorkflowStateLight programWorkflowState = new ProgramWorkflowStateLight();
        programWorkflowState.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        programWorkflowState.setCreator(1L);
        programWorkflowState.setConcept(getConcept());
        programWorkflowState.setProgramWorkflow(getProgramWorkflow());
        return programWorkflowState;
    }

    private ProgramWorkflowLight getProgramWorkflow() {
        ProgramWorkflowLight programWorkflow = new ProgramWorkflowLight();
        programWorkflow.setUuid("PLACEHOLDER_PROGRAM_WORKFLOW");
        return programWorkflow;
    }

    private ConceptLight getConcept() {
        ConceptLight concept = new ConceptLight();
        concept.setUuid("PLACEHOLDER_CONCEPT");
        return concept;
    }
}
