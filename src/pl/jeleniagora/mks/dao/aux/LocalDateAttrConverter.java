package pl.jeleniagora.mks.dao.aux;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttrConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate arg0) {
		return Date.valueOf(arg0);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date arg0) {
		// TODO Auto-generated method stub
		return arg0.toLocalDate();
	}

}
