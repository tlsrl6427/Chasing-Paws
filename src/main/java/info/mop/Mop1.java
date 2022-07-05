package info.mop;

import vo.MopVo;

public class Mop1 extends MopVo{
	
	int damage_reduced = 0;// 받는 피해 감소
	
	public void hp_damaged(int damage) {
		this.setM_hp(this.getM_hp() - damage);
	}
}
