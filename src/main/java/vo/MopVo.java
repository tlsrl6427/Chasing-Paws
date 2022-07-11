package vo;

import java.util.Map;

public class MopVo {

	int 	m_idx;
	String 	m_name;
	int 	m_hp;
	int 	m_ad;
	int m_armor;
	String 	m_skill;
	String 	m_level;

	int damage_reduced = 0;// 받는 피해 감소
	int damage_reduced_turn = 0;// 받는 피해 감소 턴수
	int dot_damage = 0;// 도트뎀
	int dot_damage_turn = 0;// 도트뎀 턴수
	int cc_turn = 0;
	
//	int blind_cc_turn = 0; // 블라인드 cc기 걸린 턴수
//	int confusion_cc_turn = 0;// 컨퓨전 cc기 걸린 턴수
//	int frozen_cc_turn = 0;// 프로즌 cc기 걸린 턴수
//	
	public void attack_character(CharacterVo main_ch, AttackVo attack_main_ch_vo) {
		attack_main_ch_vo.setDamage(this.m_ad * (5000 / ( 50 + main_ch.getC_armor() ) ) / 100);
		main_ch.setC_hp(main_ch.getC_hp() - this.m_ad * (5000 / ( 50 + main_ch.getC_armor() ) ) / 100);
		attack_main_ch_vo.setBattle_info(String.format("%s(이)가 %s에게 %d의 피해를 입혔습니다.", 
																			this.getM_name(),
																			main_ch.getC_name(),
																			this.m_ad * (5000 / ( 50 + main_ch.getC_armor() ) ) / 100));
	}

	public String extra_skill() {
		String extra_battle_info = "";
		
		if(this.cc_turn!=0) {
			this.cc_turn--;
			return "cc";
		}
		
		if(this.dot_damage_turn!=0) {
			this.dot_damage_turn--;
			this.m_hp -= this.dot_damage;
			extra_battle_info = extra_battle_info + String.format("%s가 %d의 도트뎀을 받았습니다", this.m_name, this.getDot_damage());
		}
		
		return extra_battle_info;
	}
	
	
	public int getDamage_reduced() {
		return damage_reduced;
	}



	public void setDamage_reduced(int damage_reduced) {
		this.damage_reduced = damage_reduced;
	}



	public int getDamage_reduced_turn() {
		return damage_reduced_turn;
	}



	public void setDamage_reduced_turn(int damage_reduced_turn) {
		this.damage_reduced_turn = damage_reduced_turn;
	}



	public int getCc_turn() {
		return cc_turn;
	}

	public void setCc_turn(int cc_turn) {
		this.cc_turn = cc_turn;
	}

	public int getDot_damage() {
		return dot_damage;
	}


	public void setDot_damage(int dot_damage) {
		this.dot_damage = dot_damage;
	}


	public int getDot_damage_turn() {
		return dot_damage_turn;
	}


	public void setDot_damage_turn(int dot_damage_turn) {
		this.dot_damage_turn = dot_damage_turn;
	}

	public int getM_armor() {
		return m_armor;
	}


	public void setM_armor(int m_armor) {
		this.m_armor = m_armor;
	}

	public int getM_idx() {
		return m_idx;
	}

	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_hp() {
		return m_hp;
	}

	public void setM_hp(int m_hp) {
		this.m_hp = m_hp;
	}

	public int getM_ad() {
		return m_ad;
	}

	public void setM_ad(int m_ad) {
		this.m_ad = m_ad;
	}

	public String getM_skill() {
		return m_skill;
	}

	public void setM_skill(String m_skill) {
		this.m_skill = m_skill;
	}

	public String getM_level() {
		return m_level;
	}

	public void setM_level(String m_level) {
		this.m_level = m_level;
	}

}
