library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.numeric_std.all;

-- Chenillard
entity Man4_Compteur is
port(
	clk_50, reset : in std_logic;
	leds : out std_logic_vector(0 to 3)
);
end;


architecture behavior of Man4_Compteur is

signal clk: std_logic := '0';
signal div : std_logic_vector(23 downto 0);
signal A : std_logic_vector(3 downto 0);

begin
process(clk_50, reset)
	begin 
	if reset = '0' then 
			div <= (others => '0');
			
	elsif rising_edge(clk_50) then 
			div <= div + 1;
		
	end if;
	
end process;


clk <= div(23);


process(clk, reset)
begin 
	if reset = '0' then 
			A <= "0000";			
	elsif rising_edge(clk) then 
			A <= A+1;
	end if;
	
end process;
	leds <= A;
		
end;