package jva.fh.functional.utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dive implements Serializable {	
	private static final long serialVersionUID = 4610480461453806514L;
	
	private LocalDateTime datetime;
	private String site;
	private double[] data;
	
	public Dive() { }
	
	public Dive(LocalDateTime datetime, String site, double[] data) {
		this.datetime = datetime;
		this.site = site;
		this.data = data;
	}
	public LocalDateTime getDatetime() { return datetime; }
	public void setDatetime(LocalDateTime dt) { datetime = dt; }
	
	public String getSite() { return site; }
	public void setSite(String s) { site = s; }
		
	public int getDuration() { return (data == null) ? 0 : data.length / 2; }
	
	public double[] getData() { return data; }
	public void setData(double[] d) { data = d; }
	
	public synchronized double getMaxDepth() {
		if (data == null) return 0;
		double maxD = 0;
		for (int j = 0; j < data.length; j++)
			if (data[j] > maxD) maxD = data[j];
		return maxD;
	}
	
	public String toString() { 
		return "plongee : " + site + datetime.format(DateTimeFormatter.ofPattern("'   date : 'dd-MMMM-yyyy h'h'  ")) + " duree : " + getDuration() + "mn   profondeur max : " + getMaxDepth() + "m"; } 
}
