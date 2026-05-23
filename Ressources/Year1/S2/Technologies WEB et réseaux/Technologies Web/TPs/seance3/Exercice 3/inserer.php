<?php

$lien=new mysqli("localhost","root","","Personnes");

$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
$adresse=$_POST['adresse'];
$ville=$_POST['ville'];
$code=$_POST['code'];

$requete="INSERT INTO personne(Nom,Prenom,adresse,ville,code) values('$nom','$prenom','$adresse','$ville','$code')";

$resultat=$lien->query($requete);

$lien->close();
?>