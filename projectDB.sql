/*
----------------------------------------[ user ]------------------------------------------

create table user
(
	u_idx			int,						-- User Index
	
	u_name		varchar2(100),		-- User Name
	u_id			varchar2(100),		-- User Name
	u_pwd		varchar2(100),		-- User Name
	u_score		int,						-- User Score
)

-------------------------------------[ character ]----------------------------------------

create table character
(
	c_idx 			int,						-- Character Index					*pk
	c_name 		varchar2(30),			-- Character Name
	c_hp			int,						-- Character Health Point
	c_ad			int,						-- Character Attack Damage
	c_ap 			int,						-- Character Ability Power
	c_armor 		int,						-- Character Armor
	c_critical 		int,						-- Character Critical
	c_avd			int,						-- Character Avoidability
	c_p_skill 		varchar2(30),			-- Character Passivie Skill
	c_a_skill1 	varchar2(30),			-- Character Active Skill1
	c_a_skill2 	varchar2(30),			-- Character Active Skill2
	c_a_skill3		varchar2(30),			-- Character Active Skill3
	c_a_skill4 	varchar2(30),			-- Character Active Skill4
	c_a_skill5 	varchar2(30),			-- Character Active Skill5
	c_a_skill6 	varchar2(30)			-- Character Active Skill6
)

----------------------------------------[ item ]------------------------------------------

create table item
(
	i_idx			int,						-- Item Index
	i_category	varchar2(30),			-- Item Category(머리, 상체, 하체, 무기, 물약)
	i_name 		varchar2(30),			-- Item Name
	i_effect 		varchar2(30),			-- Item Effect
)

----------------------------------------[ mop ]------------------------------------------

create table mop
(
	m_idx 		int,						-- Mop Index
	m_name 		varchar2(30),			-- Mop Name
	m_hp 			int,						-- Mop Health Point
	m_ad			int,						-- Mop Attack Damage
	m_skill 		varchar2(30),			-- Mop Skill
	m_level		varchar2(30)			-- Mop Level('보스', '중간보스', '네임드', '일반')
)


--------------------------------------[ dungeon ]----------------------------------------

create table dungeon
(
	d_idx			int,						-- Dungeon Index
	d_name		varchar2(30),			-- Dungeon Name
)


-----------------------------------[ dungeon_info ]-----------------------------------------

-- 어떤 던전에 어떤 몹들이 출현하는지
create table dungeon_info
(
	da_idx			int,						-- Dungeon_Info Index
	d_idx			int,						-- Dungeon Index					*fk
	m_idx			int,						-- Mop Index 						*fk
)













*/