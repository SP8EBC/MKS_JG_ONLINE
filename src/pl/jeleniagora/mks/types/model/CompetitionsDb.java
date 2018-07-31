package pl.jeleniagora.mks.types.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

@Entity
public class CompetitionsDb {
	
	@Id
	public int id;
	
	public long serialNum;
	
	/**
	 * Wyświetlana nazwa zawodów
	 */
	public String competitionName;
	
	/**
	 * Wyświetlana data rozgrywania zawodów
	 */
	public LocalDate date;
	
	/**
	 * String określający miejsce rozgrywania zawodów
	 */
	public String location;
	
	public String trackName;
	
	/**
	 * Ścieżka do pierwszego loga (lewy górny róg)
	 */
	public String logo1;
	
	/**
	 * Ścieżka do drugiego loga (górny drógi róg)
	 */
	public String logo2;
	
	/**
	 * Imiona i Naziwsko sędziów
	 */
	public String judge1;
	public String judge2;
	public String judge3;
	
	/**
	 * Nazwa organizatora
	 */
	public String organizer;
	
	/**
	 * Liczba konkurencji
	 */
	public int compCount;
	
	public static CompetitionsDb fromCompetitionsDef(CompetitionsDefinition def) {
		CompetitionsDb out = new CompetitionsDb();
		
		out.serialNum = def.competitionsUniqId;
		out.competitionName = def.competitionsName;
		out.compCount = def.compCount;
		out.date = def.competitionsDate;
		out.judge1 = def.judge1;
		out.judge2 = def.judge2;
		out.judge3 = def.judge3;
		out.location = def.location;
		out.logo1 = def.logo1;
		out.logo2 = def.logo2;
		
		return out;
	}
}
