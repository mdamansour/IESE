library IEEE;
use std_logic_1164.all;

entity JKFF is
	port (clk,J,K : in std_logic;
			Q : out std_logic);
end;

architecture arch_JKFF of JKFF is
signal Q_signal : std_logic;
begin
	process (clk)
	begin
		if rising_edge (clk) then
			if J='0' and K='0' then
				Q_signal <= Q_signal;
			elsif J='1' and K='0' then
				Q_signal <= '1';
			elsif J='0' and K='1' then
				Q_signal <= '0';
			else
				Q_signal <= not (Q_signal);
			end if;
		end if;
	Q <= Q_signal;
	end process;
end arch_JKFF;