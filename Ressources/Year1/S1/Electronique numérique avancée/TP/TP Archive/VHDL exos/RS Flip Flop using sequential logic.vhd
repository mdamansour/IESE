LIBRARY IEEE;
USE IEEE.std_logic_1164.all;

entity RSFF is
	PORT(
	R,S : IN std_logic;
	Q : OUT std_logic);
	END;

architecture arch_RSFF of RSFF is
		signal Q_signal : std_logic := '0';
	begin
		process (R, S)
		begin
			if(S='0' and R='0') then Q_signal <= Q_signal;
			elsif(S='0' and R='1') then Q_signal <= '0';
			elsif(S='1' and R='0') then Q_signal <= '1';
			else Q_signal <= 'X';
			end if;
		end process;
		
		Q <= Q_signal;
	end  arch_RSFF;