package vo;

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
	int blind_cc_turn = 0; // 블라인드 cc기 걸린 턴수
	int confusion_cc_turn = 0;// 컨퓨전 cc기 걸린 턴수
	int frozen_cc_turn = 0;// 프로즌 cc기 걸린 턴수
	
	public boolean skilled_by_character(int s_idx, CharacterVo main_ch) {
			
			SkillVo vo = main_ch.getSkill_s_idx(s_idx);//카테고리 구하기위함
			int skill_val = main_ch.skill_mapping(s_idx);// 실제 스킬 함수
			
			if(vo.getS_category().equals("damage")){
				this.m_hp -= skill_val;
			}else if(vo.getS_category().equals("buff")){
				return true;
			}else if(vo.getS_category().equals("cc")){
				
			}else if(vo.getS_category().equals("debuff")){
				if(skill_val/10000==1) {//사자후
					this.m_ad-=skill_val;
					this.m_armor-=skill_val;
				}
			}else if(vo.getS_category().equals("dot")){
				this.dot_damage += skill_val;
			}
			return false;
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


	public int getBlind_cc_turn() {
		return blind_cc_turn;
	}


	public void setBlind_cc_turn(int blind_cc_turn) {
		this.blind_cc_turn = blind_cc_turn;
	}


	public int getFrozen_cc_turn() {
		return frozen_cc_turn;
	}


	public void setFrozen_cc_turn(int frozen_cc_turn) {
		this.frozen_cc_turn = frozen_cc_turn;
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
