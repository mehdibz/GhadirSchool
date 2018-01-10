package Model;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table( name = "StudentCourses" )
//@TableGenerator(name = "seq", allocationSize = 110100, initialValue = 110100)
public class StudentCourses {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	
	private int Std_ID;
	private String F_description,R_description,Q_description,S_description,tot_score,dictation_score;
	private String grammar_score,reading_score,discipline_score,farsi_score,religion_score,quran_score,salat_score;
	private String FaDisciplineScore,reDisciplineScore,QuDisciplineScore,saDisciplineScore,Name,Family,ClassLevel;
	
	
	
	public int f1_getStdID() {
		return Std_ID;
	}
	public void f1_setStdID(int id) {
		this.Std_ID = id;
	}
	public String f2_getName() {
		return Name;
	}
	public void f2_setName(String Name) {
		this.Name = Name;
	}
	public String f3_getFamily() {
		return Family;
	}
	public void f3_setFamily(String Family) {
		this.Family = Family;
	}
	public String f4_getClassLevel() {
		return ClassLevel;
	}
	public void f4_setClassLevel(String classlevel) {
		this.ClassLevel = classlevel;
	}
	//=================== Farsi ==================================================		
	public String f5_getDictation_score() {
		return dictation_score;
	}
	public void f5_setDictation_score(String dictation_score) {
		this.dictation_score = dictation_score;
	}
	public String f6_getGrammar_score() {
		return grammar_score;
	}
	public void f6_setGrammar_score(String grammar_score) {
		this.grammar_score = grammar_score;
	}
	public String f7_getReading_score() {
		return reading_score;
	}
	public void f7_setReading_score(String reading_score) {
		this.reading_score = reading_score;
	}
	public String f8_getFarsi_score() {
		return farsi_score;
	}
	public void f8_setFarsi_score(String reading_score) {
		this.farsi_score = reading_score;
	}
	public String f9_getF_description() {
		return F_description;
	}
	public void f9_setF_description(String f_description) {
		this.F_description = f_description;
	}	

	//=================== Religious ==================================================	
	public String f10_getReligion_score() {
		return religion_score;
	}
	public void f10_setReligion_score(String religion_score) {
		this.religion_score = religion_score;
	}
	public String f11_getR_description() {
		return R_description;
	}
	public void f11_setR_description(String r_description) {
		this.R_description = r_description;
	}
	//=================== Quran ==================================================	
	public String f12_getQuran_score() {
		return quran_score;
	}
	public void f12_setQuran_score(String quran_score) {
		this.quran_score = quran_score;
	}
	public String f13_getQ_description() {
		return Q_description;
	}
	public void f13_setQ_description(String q_description) {
		this.Q_description = q_description;
	}
	//=================== Salat ==================================================
	public String f14_getSalat_score() {
		return salat_score;
	}
	public void f14_setSalat_score(String salat_score) {
		this.salat_score = salat_score;
	}
	public String f15_getS_description() {
		return S_description;
	}
	public void f15_setS_description(String s_description) {
		this.S_description = s_description;
	}
	//=================== DisciplineScores ==================================================
	public String f16_getFaDisciplineScore() {
		return FaDisciplineScore;
	}
	public void f16_setFaDisciplineScore(String FaDisciplineScore) {
		this.FaDisciplineScore = FaDisciplineScore;
	}
	public String f17_getReDisciplineScore() {
		return reDisciplineScore;
	}
	public void f17_setReDisciplineScore(String reDisciplineScore) {
		this.reDisciplineScore = reDisciplineScore;
	}
	public String f18_getQuDisciplineScore() {
		return QuDisciplineScore;
	}
	public void f18_setQuDisciplineScore(String QuDisciplineScore) {
		this.QuDisciplineScore = QuDisciplineScore;
	}
	public String f19_getSaDisciplineScore() {
		return saDisciplineScore;
	}
	public void f19_setSaDisciplineScore(String saDisciplineScore) {
		this.saDisciplineScore = saDisciplineScore;
	}
	public String f20_getDiscipline_score() {
		return discipline_score;
	}
	public void f20_setDiscipline_score(String discipline_score) {
		this.discipline_score = discipline_score;
	}
	//=================== Others ==================================================
	public String getTot_score() {
		return tot_score;
	}
	public void setTot_score(String tot_score) {
		this.tot_score = tot_score;
	}
}
