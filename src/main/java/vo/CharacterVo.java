package vo;

import java.util.List;

public class CharacterVo {

	int 	c_idx;
	String 	c_name;
	int 	c_hp;
	int 	c_ad;
	int 	c_ap;
	int 	c_armor;
	int 	c_critical;
	int 	c_avd;
	String	c_auto_attack;
	String 	c_p_skill;
	
	List<SkillVo> skill_vo;
	
	public SkillVo getSkill_s_idx(int s_idx) {
		
		SkillVo vo = new SkillVo();
		for(SkillVo vo1 : skill_vo)
			if(vo1.getS_idx()==s_idx)
				vo = vo1;
		
		return vo;
	}
	
	public List<SkillVo> getSkill_vo() {
		return skill_vo;
	}
	public void setSkill_vo(List<SkillVo> skill_vo) {
		this.skill_vo = skill_vo;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_hp() {
		return c_hp;
	}
	public void setC_hp(int c_hp) {
		this.c_hp = c_hp;
	}
	public int getC_ad() {
		return c_ad;
	}
	public void setC_ad(int c_ad) {
		this.c_ad = c_ad;
	}
	public int getC_ap() {
		return c_ap;
	}
	public void setC_ap(int c_ap) {
		this.c_ap = c_ap;
	}
	public int getC_armor() {
		return c_armor;
	}
	public void setC_armor(int c_armor) {
		this.c_armor = c_armor;
	}
	public int getC_critical() {
		return c_critical;
	}
	public void setC_critical(int c_critical) {
		this.c_critical = c_critical;
	}
	public int getC_avd() {
		return c_avd;
	}
	public void setC_avd(int c_avd) {
		this.c_avd = c_avd;
	}
	public String getC_auto_attack() {
		return c_auto_attack;
	}
	public void setC_auto_attack(String c_auto_attack) {
		this.c_auto_attack = c_auto_attack;
	}
	public String getC_p_skill() {
		return c_p_skill;
	}
	public void setC_p_skill(String c_p_skill) {
		this.c_p_skill = c_p_skill;
	}

	

	
}
