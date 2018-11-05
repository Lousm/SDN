package com.lou.javabean;

/*`nid` int(20) DEFAULT NULL,
 `xcoord` int(20) DEFAULT NULL,
 `ycoord` int(20) DEFAULT NULL,
 `buis` char(50) COLLATE utf8_icelandic_ci DEFAULT NULL,
 `tru` int(20) DEFAULT NULL,
 `energy` int(20) DEFAULT NULL,
 `state` char(10) COLLATE utf8_icelandic_ci DEFAULT NULL,
 `srand` int(20) DEFAULT NULL*/
public class TrunNode {
	public int nid;
	public int xcoord;
	public int ycoord;
	public String buis;
	public int tru;
	public int energy;
	public String state;
	public int srand;

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}

	public String getBuis() {
		return buis;
	}

	public void setBuis(String buis) {
		this.buis = buis;
	}

	public int getTru() {
		return tru;
	}

	public void setTru(int tru) {
		this.tru = tru;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSrand() {
		return srand;
	}

	public void setSrand(int srand) {
		this.srand = srand;
	}

}
