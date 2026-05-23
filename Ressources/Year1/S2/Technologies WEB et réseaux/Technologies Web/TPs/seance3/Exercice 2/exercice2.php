<?php

/**
 * Question 1 
 * (T1 est de type scalaire)
 */
$T1 = array("Alami", "Fes", 20);
$T2 = array("Kamali", "Rabat", 22);
$T3 = array("Tazi", "Casa", 19);


$T = array(
    "111" => $T1,
    "222" => $T2,
    "333" => $T3,
);

foreach ($T as $cin => $t) {
    echo $cin . " : ";
    foreach ($t as $v)
        echo $v . " ";
    echo "<br>";
}

/**
 * Question 2
 */


echo "<br>";

$T1_assoc = array("nom" => "Alami", "ville" => "Fes", "age" => 20);
$T2_assoc = array("nom" => "Kamali", "ville" => "Rabat", "age" => 22);
$T3_assoc = array("nom" => "Tazi", "ville" => "Casa", "age" => 19);

$T_assoc = array(
    "111" => $T1_assoc,
    "222" => $T2_assoc,
    "333" => $T3_assoc,
);

foreach ($T_assoc as $cin_assoc => $t_assoc) {
    echo $cin_assoc . " : ";
    foreach ($t_assoc as $cle_assoc => $v_assoc)
        echo $cle_assoc  . ":" . $v_assoc . "   ";
    echo "<br>";
}

?>
