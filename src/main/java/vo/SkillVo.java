package vo;

public class SkillVo {

	int s_idx;
	String s_category;
	int s_val;
	int s_turn;
	int s_valid;
	int c_idx;
	
	public int active_skill() {return 0;};
	
	public int getS_val() {
		return s_val;
	}
	public void setS_val(int s_val) {
		this.s_val = s_val;
	}
	public int getS_valid() {
		return s_valid;
	}
	public void setS_valid(int s_valid) {
		this.s_valid = s_valid;
	}
	public int getS_idx() {
		return s_idx;
	}
	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}
	public String getS_category() {
		return s_category;
	}
	public void setS_category(String s_category) {
		this.s_category = s_category;
	}
	public int getS_turn() {
		return s_turn;
	}
	public void setS_turn(int s_turn) {
		this.s_turn = s_turn;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	
	
}
