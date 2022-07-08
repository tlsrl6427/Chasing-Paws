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

	int dot_damage = 0;// 도트뎀
	int dot_damage_turn = 0;// 도트뎀 턴수
	int cc_turn = 0;
	
//	int blind_cc_turn = 0; // 블라인드 cc기 걸린 턴수
//	int confusion_cc_turn = 0;// 컨퓨전 cc기 걸린 턴수
//	int frozen_cc_turn = 0;// 프로즌 cc기 걸린 턴수
//	
	public void attack_character(CharacterVo main_ch) {
		
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
