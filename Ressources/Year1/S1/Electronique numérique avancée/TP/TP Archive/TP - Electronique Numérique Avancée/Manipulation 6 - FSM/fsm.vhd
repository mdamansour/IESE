library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.numeric_std.all;

entity fsm is
port(
    clk_50, reset, ap1 : in std_logic;
    r1, r2, v1, v2, o1, o2 : out std_logic
);
end fsm;

architecture behavior of fsm is

signal clk : std_logic := '0';
signal div : std_logic_vector(25 downto 0);
type etat17 is (E0, E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15, E16);
signal etat_present, etat_future : etat17;

begin

    process(clk_50, reset)
    begin 
        if reset = '0' then 
            div <= (others => '0');
        elsif rising_edge(clk_50) then 
            div <= div + 1;
        end if;
    end process;

    clk <= div(25);

    process(clk, reset)
    begin 
        if reset = '0' then
            etat_present <= E0;
        elsif rising_edge(clk) then
            etat_present <= etat_future;
        end if;
    end process;

    process(etat_present)
    begin 
        case etat_present is
            when E0 => 
                r1 <= '0'; r2 <= '0';
					 v1 <= '1'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E1;

            when E1 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E2;
                end if;

					 
            when E2 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E3;
                end if;
					 
            when E3 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E4;
                end if;
					 
            when E4 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E5;
                end if;
					 
            when E5 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E6;
                end if;
					 
            when E6 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
					 if ap1 = '1' then
                    etat_future <= E10;
                else
                    etat_future <= E7;
                end if;
					 
            when E7 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E8;
					 
            when E8 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '0'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E9;

            when E9 => 
                r1 <= '1'; r2 <= '0';
					 v1 <= '1'; v2 <= '1';
					 o1 <= '0'; o2 <= '1';
                etat_future <= E10;

            when E10 => 
                r1 <= '0'; r2 <= '0';
					 v1 <= '1'; v2 <= '1';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E11;

            when E11 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '0';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E12;
					 
            when E12 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '0';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E13;
					 
            when E13 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '0';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E14;
					 
            when E14 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '0';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E15;
					 
            when E15 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '0';
					 o1 <= '1'; o2 <= '1';
                etat_future <= E16;

            when E16 => 
                r1 <= '0'; r2 <= '1';
					 v1 <= '1'; v2 <= '1';
					 o1 <= '1'; o2 <= '0';
                etat_future <= E0; 
        end case;
    end process;

end behavior;