library ieee;
use ieee.std_logic_1164.all;

entity Man1_XOR is
port(a,b : in std_logic;
	s : out std_logic
);
end;

architecture behavior of Man1_XOR is

begin 
	s <= a xor b;
end;