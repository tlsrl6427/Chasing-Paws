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
	String c_img;
	
	List<SkillVo> skill_vo;
	
	int active_skill1_level =0;
	int active_skill2_level =0;
	int active_skill3_level =0;
	int active_skill4_level =0;
	int active_skill5_level =0;
	int active_skill6_level =0;
	int active_skill7_level =0;
	int active_skill8_level =0;
	
	int damage_reduced = 0;// 받는 피해 감소
	
	public int active_skill1() {return 0;}
	public int active_skill2() {return 0;}
	public int active_skill3() {return 0;}
	public int active_skill4() {return 0;}
	public int active_skill5() {return 0;}
	public int active_skill6() {return 0;}
	public int active_skill7() {return 0;}
	public int active_skill8() {return 0;}
	
	public void buff_skill(int s_idx) {
		skill_mapping(s_idx);
	}
	
	public int skill_mapping(int s_idx) {
		
			SkillVo vo = getSkill_s_idx(s_idx);
			switch(vo.getS_num()) {
				case 1: return active_skill1();
				case 2: return active_skill2();
				case 3: return active_skill3();
				case 4: return active_skill4();
				case 5: return active_skill5();
				case 6: return active_skill6();
				case 7: return active_skill7();
				case 8: return active_skill8();
				default: return 0;
			}
		
	}
	
	public SkillVo getSkill_s_idx(int s_idx) {
		
		SkillVo vo = new SkillVo();
		for(SkillVo vo1: skill_vo)
			if(vo1.getS_idx()==s_idx)
				vo = vo1;
		return vo;
	}
	
	
	
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public int getDamage_reduced() {
		return damage_reduced;
	}
	public void setDamage_reduced(int damage_reduced) {
		this.damage_reduced = damage_reduced;
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
