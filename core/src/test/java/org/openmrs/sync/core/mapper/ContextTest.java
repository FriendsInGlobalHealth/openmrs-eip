package org.openmrs.sync.core.mapper;

import org.junit.Test;
import org.openmrs.sync.core.entity.MockedEntity;
import org.openmrs.sync.core.model.MockedModel;

import static org.junit.Assert.assertNotNull;

public class ContextTest {

    private Context<MockedEntity, MockedModel> context;

    @Test
    public void getEntityBeanWrapper_should_not_be_null() {
        // Given
        MockedEntity entity = new MockedEntity(1L, "uuid");
        MockedModel model = new MockedModel("uuid");
        context = new Context<>(entity, model, MappingDirectionEnum.ENTITY_TO_MODEL);

        // When
        context.getEntityBeanWrapper();

        // Then
        assertNotNull(context.getEntityBeanWrapper());
    }

    @Test
    public void getModelBeanWrapper_should_not_be_null() {
        // Given
        MockedEntity entity = new MockedEntity(1L, "uuid");
        MockedModel model = new MockedModel("uuid");
        context = new Context<>(entity, model, MappingDirectionEnum.ENTITY_TO_MODEL);

        // When
        context.getModelBeanWrapper();

        // Then
        assertNotNull(context.getModelBeanWrapper());
    }
}
