package vo;

import java.util.List;
import java.util.Map;

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
	int damage_reduced_turn = 0;// 받는 피해 감소 턴수
	
	public void active_skill1(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill2(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill3(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill4(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill5(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill6(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill7(MopVo mopVo, AttackVo attack_mop_vo) {}
	public void active_skill8(MopVo mopVo, AttackVo attack_mop_vo) {}
	
	public void attack_mop(MopVo mopVo, AttackVo attack_mop_vo, int s_idx) {
		
		SkillVo vo = getSkill_s_idx(s_idx);
		switch(vo.getS_num()) {
			case 1: active_skill1(mopVo, attack_mop_vo); break;
			case 2: active_skill2(mopVo, attack_mop_vo); break;
			case 3: active_skill3(mopVo, attack_mop_vo); break;
			case 4: active_skill4(mopVo, attack_mop_vo); break;
			case 5: active_skill5(mopVo, attack_mop_vo); break;
			case 6: active_skill6(mopVo, attack_mop_vo); break;
			case 7: active_skill7(mopVo, attack_mop_vo); break;
			case 8: active_skill8(mopVo, attack_mop_vo); break;
			default: break;
		}
		
		/*
		if(s_idx==0) {
			mop.setM_hp(mop.getM_hp() - this.getC_ad() * ( 5000 / ( 50 + mop.getM_armor() ) ));
			map.put("평타피해", this.getC_ad() * ( 5000 / ( 50 + mop.m_armor ) ));
		}
	
		SkillVo vo = this.getSkill_s_idx(s_idx);//카테고리 구하기위함
		skill_mapping(s_idx, attack_mop_vo);
		
		if(vo.getS_category().equals("damage")){
			int skill_val = this.skill_mapping(s_idx);// 실제 스킬 함수
			mop.setM_hp(mop.getM_hp() - skill_val * ( 5000 / ( 50 + mop.getM_armor() ) ) );
			//map.put("스킬피해", skill_val);
		}else if(vo.getS_category().equals("buff")){
			int skill_idx = this.skill_mapping(s_idx);// 실제 스킬 함수
			
			map.put("버프", );
			
		}else if(vo.getS_category().equals("cc")){
			int skill_val = main_ch.skill_mapping(s_idx);// 실제 스킬 함수
			this.cc_turn += skill_val /100000;
		}else if(vo.getS_category().equals("debuff")){
			int skill_val = main_ch.skill_mapping(s_idx);// 실제 스킬 함수
			if(skill_val/10000==1) {//사자후
				this.m_ad-=skill_val;
				this.m_armor-=skill_val;
				map.put("디버프", skill_val);
			}
		}else if(vo.getS_category().equals("dot")){
			this.dot_damage += skill_val%1000;
			this.dot_damage_turn += skill_val/1000;
		}
		
		//도트뎀
		if(dot_damage_turn!=0){
			this.m_hp-=dot_damage;
			dot_damage_turn--;
		}
		return map;
		*/
	}
	
	public SkillVo getSkill_s_idx(int s_idx) {
		
		SkillVo vo = new SkillVo();
		for(SkillVo vo1: skill_vo)
			if(vo1.getS_idx()==s_idx)
				vo = vo1;
		return vo;
	}
	
	
	
	public int getDamage_reduced_turn() {
		return damage_reduced_turn;
	}
	public void setDamage_reduced_turn(int damage_reduced_turn) {
		this.damage_reduced_turn = damage_reduced_turn;
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
