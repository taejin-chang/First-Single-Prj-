package dto;

public class ManagerDTO {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_tel;
	
	public ManagerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ManagerDTO(String m_id, String m_pw, String m_name, String m_tel) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_tel = m_tel;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	
}
