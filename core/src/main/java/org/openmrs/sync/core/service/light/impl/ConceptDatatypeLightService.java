package org.openmrs.sync.core.service.light.impl;

import org.openmrs.sync.core.entity.light.ConceptDatatypeLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.openmrs.sync.core.service.light.AbstractLightService;
import org.springframework.stereotype.Service;

@Service
public class ConceptDatatypeLightService extends AbstractLightService<ConceptDatatypeLight> {

    public ConceptDatatypeLightService(final OpenMrsRepository<ConceptDatatypeLight> repository) {
        super(repository);
    }

    @Override
    protected ConceptDatatypeLight createPlaceholderEntity(final String uuid) {
        ConceptDatatypeLight conceptDatatype = new ConceptDatatypeLight();
        conceptDatatype.setDateCreated(DEFAULT_DATE);
        conceptDatatype.setCreator(DEFAULT_USER_ID);
        conceptDatatype.setName(DEFAULT_STRING);
        return conceptDatatype;
    }
}
