package org.openmrs.sync.core.camel;

import org.apache.camel.Exchange;
import org.apache.camel.TypeConversionException;
import org.apache.camel.support.TypeConverterSupport;
import org.openmrs.sync.core.utils.DateUtils;

public class StringToLocalDateTimeConverter extends TypeConverterSupport {

    @Override
    public <T> T convertTo(final Class<T> type, final Exchange exchange, final Object value) throws TypeConversionException {
        if (value == null) {
            return null;
        }
        String valueAsString = (String) value;
        if (valueAsString.isEmpty()) {
            return null;
        }
        return (T) DateUtils.fromString(valueAsString);
    }

    @Override
    public boolean allowNull() {
        return true;
    }
}