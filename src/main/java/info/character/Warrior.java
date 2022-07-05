package info.character;

import java.util.List;

import vo.CharacterVo;
import vo.SkillVo;

public class Warrior extends CharacterVo{

	int damage_reduced = 0;// 받는 피해 감소
	
	SkillVo vo1 = new ActiveSkill1();
	
	public class ActiveSkill1 extends SkillVo{

		@Override
		public int active_skill() {
			// TODO Auto-generated method stub
			//어스 브레이크 10(1.5ad)
			
			return 10 + getC_ad() * 3 / 2;
		}
		
	}
	
	public class ActiveSkill2 extends SkillVo{

		@Override
		public int active_skill() {
			// TODO Auto-generated method stub
			//러닝 크래쉬 80입히고/20받기
			setC_hp(getC_hp()-20);
			return 80;
		}
		
	}
	
	public void init() {
		vo1 = this.getSkill_vo().get(0);
	}
	
	
	public int active_skill1() {
		//어스 브레이크 10(1.5ad)
		
		return 10 + this.getC_ad() * 3 / 2;
	}
	
	public int active_skill2() {
		//러닝 크래쉬 80입히고/20받기
		this.setC_hp(this.getC_hp()-20);
		return 80;
	}
	
	public int active_skill3() {
		//소울 슬래쉬 50(1.0ad)(0.6ap)
		return 50 + this.getC_ad() + this.getC_ap() * 3 / 5;
	}
	
	public int active_skill4() {
		//심판의 검 (잃은 체력 or 총 체력 비례 ?)
		return 0;
	}
	
	public int active_skill5() {
		//아테나의 축복 5/5 증가
		this.setC_auto_attack(this.getC_auto_attack() + 5);
		this.setC_armor(this.getC_armor() + 5);
		return 0;
	}
	
	public int active_skill6() {
		//아이언 바디(받는 피해 감소)
		this.damage_reduced += 5;
		return 0;
	}
	
	public int active_skill7() {
		//오러블레이드(출혈)
		return 5;
	}
	
	public int active_skill8() {
		//사자후(상대 공격력, 방어력 감소)
		return 10;
	}
}
