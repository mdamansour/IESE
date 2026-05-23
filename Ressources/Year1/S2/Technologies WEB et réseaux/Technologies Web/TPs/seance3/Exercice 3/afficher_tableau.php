<?php

    echo "<b>Vos coordonnees:</b>";
    echo "<table border=1>";
    foreach($_POST as $cle => $val){
        echo "<tr><td>" . $cle . "</td><td>" . $val . "</td></tr>";
    }


    echo "</table>";

?>