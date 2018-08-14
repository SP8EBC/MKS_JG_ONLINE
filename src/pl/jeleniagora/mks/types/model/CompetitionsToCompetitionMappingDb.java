package pl.jeleniagora.mks.types.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitions_to_competition_mapping")
public class CompetitionsToCompetitionMappingDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generowanie kolejnych wartości przerzucone na bazę danych
	public Integer id;
	
	public String competitionsName;
	
	public Long competitionSerialNumber;
}
