package org.openmrs.sync.core.service.light;

import org.openmrs.sync.core.entity.light.MockedAttributeTypeLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;

public class MockedAttributeTypeLightService extends AbstractAttributeTypeLightService<MockedAttributeTypeLight> {

    public MockedAttributeTypeLightService(final OpenMrsRepository<MockedAttributeTypeLight> repository) {
        super(repository);
    }

    @Override
    protected MockedAttributeTypeLight createEntity() {
        return new MockedAttributeTypeLight(null, null);
    }
}
