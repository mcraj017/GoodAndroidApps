package com.example.learnmalay;

public class LoginTable {
	int id;  
	String USERNAME;  
	String PASSWORD;
	int GRAMMARSCORE =0;
	int VERBSCORE =0;
	int DICTIONARYSCORE =0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getGRAMMARSCORE() {
		return GRAMMARSCORE;
	}
	public void setGRAMMARSCORE(int gRAMMARSCORE) {
		GRAMMARSCORE = gRAMMARSCORE;
	}
	public int getVERBSCORE() {
		return VERBSCORE;
	}
	public void setVERBSCORE(int vERBSCORE) {
		VERBSCORE = vERBSCORE;
	}
	public int getDICTIONARYSCORE() {
		return DICTIONARYSCORE;
	}
	public void setDICTIONARYSCORE(int dICTIONARYSCORE) {
		DICTIONARYSCORE = dICTIONARYSCORE;
	}

}
