package org.openmrs.sync.core.service.light.impl;

import org.openmrs.sync.core.entity.light.FormLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.openmrs.sync.core.service.light.AbstractLightService;
import org.springframework.stereotype.Service;

@Service
public class FormLightService extends AbstractLightService<FormLight> {

    public FormLightService(final OpenMrsRepository<FormLight> repository) {
        super(repository);
    }

    @Override
    protected FormLight createPlaceholderEntity(final String uuid) {
        FormLight form = new FormLight();
        form.setName(DEFAULT_STRING);
        form.setVersion(DEFAULT_STRING);
        form.setCreator(DEFAULT_USER_ID);
        form.setDateCreated(DEFAULT_DATE);
        return form;
    }
}
