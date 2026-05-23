LIBRARY IEEE;
USE IEEE.std_logic_1164.all;

entity REG_DEC is
	PORT(
	clk,E,rst,LOAD : IN std_logic;
	D : IN std_logic_vector(7 downto 0);
	Q : OUT std_logic_vector(7 downto 0)
	);
END REG_DEC;

architecture arch_REG_DEC of REG_DEC is
	signal X : std_logic_vector(7 downto 0);
	begin
		process (clk,rst)
		begin
			if (rst = '1') then X <="00000000";
			elsif (clk'event and clk ='1') then
				if (LOAD ='1') then X <= D;
				else X <= E & X(7 downto 1);
				end if;
			end if;
		end process;
		Q <= X;
	end  arch_REG_DEC;