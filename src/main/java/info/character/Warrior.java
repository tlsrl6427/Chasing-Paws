package info.character;

import java.util.List;

import vo.AttackVo;
import vo.CharacterVo;
import vo.MopVo;
import vo.SkillVo;

public class Warrior extends CharacterVo{

	
	
	public void active_skill1(MopVo mopVo, AttackVo attack_mop_vo) {
		//어스 브레이크 10(1.5ad)
		System.out.println("어스 브레이크!");
		int damage = 10 + this.getC_ad() * 3 / 2;
		attack_mop_vo.setDamage(damage);
		mopVo.setM_hp(mopVo.getM_hp() - damage * ( 5000 / ( 50 + mopVo.getM_armor() ) ) );
	}
	
	public void active_skill2(MopVo mopVo, AttackVo attack_mop_vo) {
		//러닝 크래쉬 80입히고/20받기
		System.out.println("러닝 크래쉬!");
		int self_damage = 20;
		int damage = 80;
		attack_mop_vo.setSelf_damage(self_damage);
		attack_mop_vo.setDamage(damage);
		mopVo.setM_hp(mopVo.getM_hp() - damage * ( 5000 / ( 50 + mopVo.getM_armor() ) ) );
	}
	
	public void active_skill3(MopVo mopVo, AttackVo attack_mop_vo) {
		//소울 슬래쉬 50(1.0ad)(0.6ap)
		System.out.println("소울 슬래쉬!");
		//return 50 + this.getC_ad() + this.getC_ap() * 3 / 5;
	}
	
	public void active_skill4(MopVo mopVo, AttackVo attack_mop_vo) {
		//심판의 검 (잃은 체력 or 총 체력 비례 ?)
		System.out.println("심판의 검!");
		//return 0;
	}
	
	public void active_skill5(MopVo mopVo, AttackVo attack_mop_vo) {
		//아테나의 축복 5/5 증가
		System.out.println("--아테나의 축복--!");
		this.setC_ad(this.getC_ad() + 5);
		this.setC_armor(this.getC_armor() + 5);
		//return 5;
	}
	
	public void active_skill6(MopVo mopVo, AttackVo attack_mop_vo) {
		//아이언 바디(받는 피해 감소)
		System.out.println("아이언 바디!");
		this.setDamage_reduced(getDamage_reduced()+5);
		this.setDamage_reduced_turn(5);
		//return 6;
	}
	
	public void active_skill7(MopVo mopVo, AttackVo attack_mop_vo) {
		//오러블레이드(출혈)
		System.out.println("오러블레이드!");
		//return 5 * 1000 + 5;
	}
	
	public void active_skill8(MopVo mopVo, AttackVo attack_mop_vo) {
		//사자후(상대 공격력, 방어력 감소)
		System.out.println("사자후!");
		//return 10000 + 10;
	}
}
