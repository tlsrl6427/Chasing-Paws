package info.mop;

import vo.MopVo;

public class Mop1 extends MopVo{
	
	public void hp_damaged(int damage) {
		this.setM_hp(this.getM_hp() - damage);
	}
}
