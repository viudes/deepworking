package br.com.deepworking.project.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.deepworking.project.model.ScorePoint;

@Converter(autoApply = true)
public class ScorePointConverter implements AttributeConverter<ScorePoint, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ScorePoint attribute) {
        return attribute.getPoint();
    }

    @Override
    public ScorePoint convertToEntityAttribute(Integer dbData) {
        return ScorePoint.fromInteger(dbData);
    }

}
