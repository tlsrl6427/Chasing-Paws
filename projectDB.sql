/*
----------------------------------------[ user ]------------------------------------------


-------------------------------------[ character ]----------------------------------------

create table character
(
	c_idx 			int,						-- Character Index
	c_name 		varchar2(30),			-- Character Name
	c_hp			int,						-- Character Health Point
	c_mp			int,						-- Character Mana Point
	c_strong 		int,						-- Character Stat(Strongness)
	c_dex 			int,						-- Character Stat(Dexterity)
	c_int 			int,						-- Character Stat(Intelligence)
	c_luck 		int,						-- Character Stat(Luck)
	c_skill1 		varchar2(30),			-- Character Skill1
	c_skill2 		varchar2(30),			-- Character Skill2
	c_skill3		varchar2(30),			-- Character Skill3
	c_skill4 		varchar2(30),			-- Character Skill4
	c_skill5 		varchar2(30),			-- Character Skill5
	i_idx1 			int,						-- Item1 								*fk
	i_idx2 			int,						-- Item2 								*fk
	i_idx3 			int,						-- Item3 								*fk
	i_idx4 			int,						-- Item4 								*fk
	i_idx5 			int,						-- Item5 								*fk
	i_idx6 			int						-- Item6 								*fk
)

----------------------------------------[ item ]------------------------------------------

create table item
(
	i_idx			int,						-- Item Index
	i_name 		varchar2(30),			-- Item Name
	i_effect 		varchar2(30),			-- Item Effect
	i_level			int						-- Item Level(ÀÏ¹Ý, Æ¯º°, Èñ±Í, Àü¼³)
)


----------------------------------------[ mop ]------------------------------------------

create table mop
(
	m_idx 		int,						-- Mop Index
	m_name 		varchar2(30),			-- Mop Name
	m_hp 			int,						-- Mop Health Point
	m_mp 		int,						-- Mop Mana Point
	m_skill 		varchar2(30)			-- Mop Skill
)

--------------------------------------[ dungeon ]----------------------------------------

create table dungeon
(
	d_idx			int,						-- Dungeon Index
	d_name		varchar2(30),			-- Dungeon Name
)


-----------------------------------[ dungeon_appr ]-----------------------------------------

create table dungeon_appr
(
	da_idx			int,						-- Dungeon Appearance Index
	d_idx			int,						-- Dungeon Index					*fk
	m_idx			int,						-- Mop Index 						*fk
)













*/