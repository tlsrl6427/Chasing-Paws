/*
----------------------------------------[ user ]------------------------------------------

create table user
(
	u_idx				int,						-- User Index
	u_name				varchar2(100),				-- User Name
	u_id				varchar2(100),				-- User Name
	u_pwd				varchar2(100),				-- User Name
	u_score				int							-- User Score
)

-------------------------------------[ character ]----------------------------------------

create table character_info
(
	c_idx 				int,						-- Character Index					*pk
	c_name 				varchar(30),				-- Character Name
	c_hp				int,						-- Character Health Point
	c_ad				int,						-- Character Attack Damage
	c_ap 				int,						-- Character Ability Power
	c_armor 			int,						-- Character Armor
	c_critical 			int,						-- Character Critical
	c_avd				int,						-- Character Avoidability
	c_auto_attack		varchar(30),				-- Character Auto Attack
	c_p_skill 			varchar(30),				-- Character Passivie Skill
	c_a_skill1 			varchar(30),				-- Character Active Skill1
	c_a_skill2 			varchar(30),				-- Character Active Skill2
	c_a_skill3			varchar(30),				-- Character Active Skill3
	c_a_skill4 			varchar(30),				-- Character Active Skill4
	c_a_skill5 			varchar(30),				-- Character Active Skill5
	c_a_skill6 			varchar(30),				-- Character Active Skill6
	c_a_skill7 			varchar(30),				-- Character Active Skill7
	c_a_skill8 			varchar(30)					-- Character Active Skill8
)

alter table character_info add column c_img varchar(255)

----------------------------------------[ item ]------------------------------------------


create table item
(
	i_idx				int auto_increment,			-- Item Index
	i_class				varchar(30),				-- Item Class('공용', '전사', '궁수', '법사')
	i_category			varchar(30),				-- Item Category('머리', '상체', '하체', '무기', '물약')
	i_name 				varchar(30),				-- Item Name
	i_level				varchar(30),				-- Item Level('일반', '고급', '희귀', '전설')
	PRIMARY KEY (i_idx)
)

----------------------------------------[ mop ]------------------------------------------

create table mop
(
	m_idx 				int,						-- Mop Index
	m_name 				varchar(30),				-- Mop Name
	m_hp 				int,						-- Mop Health Point
	m_ad				int,						-- Mop Attack Damage
	m_skill 			varchar(30),				-- Mop Skill
	m_level				varchar(30)					-- Mop Level('일반', '네임드', '중간보스', '보스')
)


--------------------------------------[ dungeon ]----------------------------------------

create table dungeon
(
	d_idx				int,						-- Dungeon Index
	d_name				varchar(30),				-- Dungeon Name
)


-----------------------------------[ dungeon_info ]-----------------------------------------

-- 어떤 던전에 어떤 몹이 나올지의 정보
create table dungeon_info
(
	da_idx				int,						-- Dungeon_Info Index
	d_idx				int,						-- Dungeon Index					*fk
	m_idx				int,						-- Mop Index 						*fk
)













*/