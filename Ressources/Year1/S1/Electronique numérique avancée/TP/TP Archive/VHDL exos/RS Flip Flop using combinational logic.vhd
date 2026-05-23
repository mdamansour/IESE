LIBRARY IEEE;
USE IEEE.std_logic_1164.all;

entity RSFF is
	PORT(
	R,S : IN std_logic;
	Q : OUT std_logic);
	END;

architecture arch_RSFF of RSFF is
	signal X std_logic;
	begin
		X <= '1' when S='1' and R='0' else
			'0' when S='0' and R='1' else
			 X  when S='0' and R='0' else
			'X';
		Q <= X;
	end  arch_RSFF;