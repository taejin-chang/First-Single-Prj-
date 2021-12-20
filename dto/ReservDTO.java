package dto;

public class ReservDTO {
	private int r_no;
	private String title;
	private String r_name;
	private String tel;
	private String r_loc;
	private String open_date;
	private String r_grade;
	private String r_date;
	private String alarm_date;

public ReservDTO() {
}

public ReservDTO(int r_no, String title, String r_name, String tel, String r_loc, String open_date, String r_grade,
		String r_date, String alarm_date) {
	this.r_no = r_no;
	this.title = title;
	this.r_name = r_name;
	this.tel = tel;
	this.r_loc = r_loc;
	this.open_date = open_date;
	this.r_grade = r_grade;
	this.r_date = r_date;
	this.alarm_date = alarm_date;
}

public int getR_no() {
	return r_no;
}

public void setR_no(int r_no) {
	this.r_no = r_no;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getR_name() {
	return r_name;
}

public void setR_name(String r_name) {
	this.r_name = r_name;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getR_loc() {
	return r_loc;
}

public void setR_loc(String r_loc) {
	this.r_loc = r_loc;
}

public String getOpen_date() {
	return open_date;
}

public void setOpen_date(String open_date) {
	this.open_date = open_date;
}

public String getR_grade() {
	return r_grade;
}

public void setR_grade(String r_grade) {
	this.r_grade = r_grade;
}

public String getR_date() {
	return r_date;
}

public void setR_date(String r_date) {
	this.r_date = r_date;
}

public String getAlarm_date() {
	return alarm_date;
}

public void setAlarm_date(String alarm_date) {
	this.alarm_date = alarm_date;
}



}
