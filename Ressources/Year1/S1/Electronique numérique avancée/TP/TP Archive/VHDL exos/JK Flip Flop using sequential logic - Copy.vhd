library IEEE;
use std_logic_1164.all;

entity exercise is
	port (clk,A,B,SEL : in std_logic;
			Q : out std_logic);
end;

architecture arch_exercise of exercise is

signal X,Y,Z,Q_signal : std_logic;
begin
	
	X <= A xor B;
	Y <= A and B;
	Z <= X when SEL = '1' else
		 Y;
	
	process (clk)
	begin
		if rising_edge (clk) then
			Q_signal <= Z;
		end if;
	end process;
	Q <= Q_signal;
end arch_exercise;