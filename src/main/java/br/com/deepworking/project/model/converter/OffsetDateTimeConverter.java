package br.com.deepworking.project.model.converter;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Thanks to http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa/ post
 *
 * @author hastronauta
 */
@Converter(autoApply = true)
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(OffsetDateTime attribute) {
        return attribute == null ? null : Date.from(attribute.toInstant());
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : OffsetDateTime.ofInstant(dbData.toInstant(), ZoneId.systemDefault());
    }

}
