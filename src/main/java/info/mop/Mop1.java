package info.mop;

import vo.CharacterVo;
import vo.MopVo;
import vo.SkillVo;

public class Mop1 extends MopVo{
	
	int damage_reduced = 0;// 받는 피해 감소
	
	public boolean skilled_by_character(int s_idx, CharacterVo main_ch) {
		
		SkillVo vo = main_ch.getSkill_s_idx(s_idx);
		//vo =skill_dao.selectOne(s_idx);
		if(vo.getS_category().equals("damage")){
			this.setM_hp(this.getM_hp()-vo.getS_val());
		}else if(vo.getS_category().equals("buff")){
			return true;
		}else if(vo.getS_category().equals("cc")){
			
		}else if(vo.getS_category().equals("debuff")){
			
		}else if(vo.getS_category().equals("dot")){
			
		}
		return false;
	}
}
