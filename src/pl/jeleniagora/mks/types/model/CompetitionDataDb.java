package pl.jeleniagora.mks.types.model;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitionData")
public class CompetitionDataDb {

	@Id
	public int id;
	
//	@Column(name = "`competitionSerialNumber`")
	public long competitionSerialNumber;
	
	public int competitionId;
	
	public String competitorName;
	
	public int competitorStartNumber;
	
	public int competitorRank;
	
	public int competitorPartialRank;
	
	public String clubName;
	
	public Vector<String> trainingRunsTimesStr;
	
	public Vector<String> scoredRunsTimesStr;
	
	
}
