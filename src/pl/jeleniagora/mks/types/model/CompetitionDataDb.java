package pl.jeleniagora.mks.types.model;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

@Entity
@Table(name = "competition_data")
@TypeDef(name = "string-array", typeClass = StringArrayType.class)
public class CompetitionDataDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generowanie kolejnych wartości przerzucone na bazę danych
	public int id;
	
	public long competitionSerialNumber;

	public int competitionId;
	
	public String competitorName;
	
	public int competitorStartNumber;
	
	public int competitorRank;
	
	public int competitorPartialRank;
	
	public String clubName;
	
	@Type(type = "string-array")
	@Column(columnDefinition="text[]")
	public String[] trainingRunsTimesStr;

	@Type(type = "string-array")
	@Column(columnDefinition="text[]")
	public String[] scoredRunsTimesStr;
	
	public String totalScoredTimeStr;
	
	@Column(nullable = true)
	public Integer birthYear;
	
	
	
}
