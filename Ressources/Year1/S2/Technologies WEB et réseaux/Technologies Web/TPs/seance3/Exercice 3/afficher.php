<?php

$lien = new mysqli("localhost", "root", "", "Personnes");

$requete = "SELECT * FROM personne";
$resultat = $lien->query($requete);

echo "<table border='1'>";
echo "<tr><th>Nom</th><th>Prenom</th><th>Adresse</th><th>Ville</th><th>Code postal</th></tr>";

while ($prod = $resultat->fetch_assoc()) {
    echo "<tr>";
    echo "<td>" . $prod['Nom'] . "</td>";
    echo "<td>" . $prod['Prenom'] . "</td>";
    echo "<td>" . $prod['adresse'] . "</td>";
    echo "<td>" . $prod['ville'] . "</td>";
    echo "<td>" . $prod['code'] . "</td>";
    echo "</tr>";
}

echo "</table>";

$lien->close();
?>