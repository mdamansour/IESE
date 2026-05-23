# Technologies Web — Résumé du Cours

**Pr. Abdelali Boushaba** | Master IESE | 2025-2026

---

## Plan Général du Cours

| Chapitre | Sujet |
|----------|-------|
| 1 | Les concepts |
| **2** | **Le langage HTML** ← *(ce résumé)* |
| 3 | Le langage CSS |
| 4 | Le langage JavaScript |
| 5 | Le langage PHP |

---

# Chapitre 2 : Le langage HTML

## 1. Introduction — Qu'est-ce que HTML ?

**HTML** = **H**yper**T**ext **M**arkup **L**anguage

- Langage composé d'un ensemble de **balises** (tags)
- Utilisé pour décrire des documents : textuels, hypertextes, multimédias, etc.
- Une balise permet la **mise en page** et la **mise en forme** du contenu d'une page web

### 1.1 Syntaxe des balises

```
<balise attributs>contenu</balise>       ← balise avec contenu
<balise attributs>                        ← balise auto-fermante (sans contenu)
```

| Terme | Rôle |
|-------|------|
| `<balise attributs>` | **Balise ouvrante** |
| `</balise>` | **Balise fermante** |
| `contenu` | Texte ou d'autres balises imbriquées |
| `attributs` | Paramètres sous forme `nom="valeur"`, séparés par des espaces |

**Exemple :**
```html
<h1 id="premierEntete">Introduction</h1>
```
- `h1` → nom de la balise
- `id="premierEntete"` → attribut (nom=`id`, valeur=`premierEntete`)
- `Introduction` → contenu

### 1.2 Balises auto-fermantes

- Pas de contenu, peuvent s'écrire `<nomBalise/>` ou `<nomBalise>`
- Exemples :
  - `<br>` — saut de ligne
  - `<hr size="2" width="500" align="center">` — trait horizontal

### 1.3 L'accentuation & caractères spéciaux

> Historiquement, le HTML était encodé en ASCII 7 bits → pas de caractères accentués.
> Aujourd'hui, les dernières versions prennent en charge les accents (UTF-8).

| Caractère | Entité HTML | Code ASCII |
|-----------|-------------|------------|
| â | `&acirc;` | `&#226;` |
| é | `&eacute;` | `&#233;` |
| è | `&egrave;` | `&#232;` |
| à | `&agrave;` | `&#224;` |
| ù | `&ugrave;` | `&#249;` |
| ç | `&ccedil;` | `&#231;` |
| û | `&ucirc;` | `&#251;` |

---

## 2. Structure générale d'un document HTML

```html
<!DOCTYPE html>          <!-- Déclare un document HTML5 -->
<html>
  <head>                 <!-- En-tête (métadonnées) -->
    <title>Titre de la page</title>
  </head>
  <body>                 <!-- Corps du document (contenu visible) -->
    ...
  </body>
</html>
```

**Remarques :**
- Les balises **ne sont pas sensibles à la casse** : `<HTML>` = `<Html>` = `<html>`
- Commentaires : `<!-- ceci est un commentaire -->`
- `<!DOCTYPE html>` indique au navigateur qu'il s'agit d'un document HTML5

### 2.1 Extensions des pages web

| Extension | Description |
|-----------|-------------|
| `.htm`, `.html` | Pages HTML statiques |
| `.php`, `.php3`, `.php4`, `.phtml` | Pages PHP (serveur web requis) |
| `.asp` | Active Server Page (serveur web requis) |
| `.cgi` | Fichiers CGI (serveur web requis) |
| `.pl` | Fichiers Perl (serveur web requis) |
| `.shtml` | Servlets (serveur web requis) |

> Page d'accueil par défaut : `index.html` ou `index.htm`

### 2.2 L'en-tête `<head>`

- Contient des **métadonnées** (non affichées dans le corps)
- `<title>` est **obligatoire** dans `<head>`
- L'élément `<meta>` spécifie des couples **propriété/valeur**

```html
<meta name="Auteur" content="Alami Ali">
<meta name="keywords" content="vacances, soleil" lang="fr">
<meta charset="utf-8">   <!-- Encodage UTF-8 -->
```

### 2.3 Attributs de `<body>`

| Attribut | Rôle |
|----------|------|
| `bgcolor="#RRVVBB"` | Couleur de fond |
| `text="#RRVVBB"` | Couleur du texte |
| `link="#RRVVBB"` | Couleur des liens |
| `vlink="#RRVVBB"` | Couleur des liens visités |
| `alink="#RRVVBB"` | Couleur des liens lors de sélection |
| `background="image.gif"` | Image de fond |

### 2.4 Les couleurs en HTML

3 façons de spécifier une couleur :

| Méthode | Exemple |
|---------|---------|
| **Hexadécimal** `#RRGGBB` | `#FF0000` (rouge) |
| **Nom anglais** | `red`, `green`, `blue` |
| **rgb(R, G, B)** (0-255) | `rgb(255, 0, 0)` (rouge) |

---

## 3. Mise en forme

### 3.1 Le texte

| Action | Balise |
|--------|--------|
| Saut de ligne | `<br>` |
| Trait horizontal | `<hr size="" width="" align="">` |
| Commentaire | `<!-- commentaire -->` |
| **Gras** | `<b>...</b>` |
| *Italique* | `<i>...</i>` ou `<em>...</em>` |
| <u>Souligné</u> | `<u>...</u>` |

### 3.2 La balise `<font>`

```html
<font color="couleur" size="taille" face="police(s)">Texte</font>
```

| Attribut | Détail |
|----------|--------|
| `color` | Couleur (nom anglais ou `#hex`) |
| `size` | Taille de 1 à 7 (défaut : 3) |
| `face` | Police(s), séparées par des virgules (défaut : Times New Roman) |

- `<big>` : augmente la taille d'un cran
- `<small>` : diminue la taille d'un cran

### 3.3 Les titres `<h1>` à `<h6>`

```html
<h1>Titre 1</h1>   <!-- Le plus grand -->
<h2>Titre 2</h2>
<h3>Titre 3</h3>
<h4>Titre 4</h4>
<h5>Titre 5</h5>
<h6>Titre 6</h6>   <!-- Le plus petit -->
```

### 3.4 Les paragraphes

```html
<p>Paragraphe 1</p>
<p>Paragraphe 2</p>
```

### 3.5 Les alignements

```html
<p align="left">Gauche (défaut)</p>
<p align="center">Centré</p>
<p align="right">Droite</p>
<p align="justify">Justifié</p>
```

### 3.6 Les listes

#### a) Listes ordonnées (numérotées) `<ol>`

```html
<ol>
  <li>Premier</li>
  <li>Deuxième</li>
</ol>
```

| Attribut | Effet |
|----------|-------|
| `start="10"` | Commencer à partir de 10 |
| `<li value="98">` | Forcer une valeur |
| `type="1"` | Chiffres arabes |
| `type="A"` | Lettres majuscules |
| `type="a"` | Lettres minuscules |
| `type="I"` | Chiffres romains majuscules |
| `type="i"` | Chiffres romains minuscules |

> Exemple : commencer à F → `<ol type="A" start="6">`

#### b) Listes non ordonnées `<ul>`

```html
<ul>
  <li>Élément</li>
  <li type="disc">Disque plein</li>
  <li type="square">Carré</li>
  <li type="circle">Cercle vide</li>
</ul>
```

Image comme puce :
```html
<ul style="list-style-image:url(note.gif)">
```

#### c) Listes descriptives `<dl>`

```html
<dl>
  <dt>ASCII</dt>
  <dd>Jeu de caractères qui assigne des valeurs numériques...</dd>
  <dt>EPS</dt>
  <dd>Format de description de fichiers PostScript</dd>
</dl>
```
- `<dt>` = terme (item)
- `<dd>` = description de l'item

### 3.7 Division graphique — `<hr>`

| Attribut | Rôle |
|----------|------|
| `size` | Épaisseur du trait |
| `width` | Longueur (en % ou pixels) |
| `align` | Alignement (si largeur < 100%) |
| `noshade` | Supprime l'effet de relief |

### 3.8 Autres balises de mise en forme

| Balise | Rôle |
|--------|------|
| `<div>` | Définit un **bloc** (texte, liens, images, tableaux…) |
| `<span>` | Définit un bloc **en ligne** (une seule ligne) |
| `<center>` | Centre un élément ou un bloc |
| `<address>` | Adresse postale |
| `<blockquote>` | Citation |
| `<dfn>` | Définition |

---

## 4. Les liens

### 4.1 Syntaxe de base

```html
<a href="monfichier.html">Mon lien</a>
```

### 4.2 Attributs d'un lien

| Attribut | Rôle |
|----------|------|
| `href` | Chemin d'accès de la page cible |
| `title` | Info-bulle au survol |
| `target` | Cadre de destination (`_blank` = nouvelle fenêtre) |

```html
<a href="test.html" title="lien vers test" target="_blank">Lien vers test</a>
```

### 4.3 Les ancres (liens internes)

```html
<!-- Définir une ancre -->
<a name="monancre"></a>

<!-- Lien vers l'ancre (même page) -->
<a href="#monancre">Aller à l'ancre</a>

<!-- Lien vers l'ancre d'un autre fichier -->
<a href="monfichier.html#monancre">Aller à l'ancre</a>
```

> Toujours un **#** devant le nom de l'ancre dans `href`

### 4.4 Types de fichiers appelables

| Type | Exemple |
|------|---------|
| Page HTML | `<a href="page.html">...</a>` |
| Image | `<a href="image.jpg">...</a>` |
| Ancre | `<a href="#ancre">...</a>` |
| Téléchargement | `<a href="programme.exe">...</a>` |
| Email | `<a href="mailto:a.kamali@gmail.com">...</a>` |

---

## 5. Les images

### 5.1 Insertion d'une image

```html
<img src="chemin/image.jpg" border="1" width="200" height="100" alt="description">
```

### 5.2 Image en arrière-plan

```html
<body background="image.jpg">
```

### 5.3 Image comme lien

```html
<a href="lien.html"><img src="image.jpeg"></a>
```

### 5.4 Formats d'image

| Format | Caractéristique |
|--------|-----------------|
| **JPEG** | Très bon taux de compression |
| **GIF** | Taux de compression moins bon |

### 5.5 Attributs de `<img>`

| Attribut | Rôle |
|----------|------|
| `src` | Chemin de l'image |
| `title` | Info-bulle |
| `border` | Taille de la bordure |
| `vspace` | Espace vertical image/texte |
| `hspace` | Espace horizontal image/texte |
| `align` | Alignement (left, right, top, middle, bottom…) |
| `width` | Largeur en pixels (ou %) |
| `height` | Hauteur en pixels |
| `alt` | Texte alternatif si l'image ne s'affiche pas |
| `name` | Nom de l'image |

---

## 6. Les tableaux

### 6.1 Structure de base

```html
<table border="1">
  <caption>Titre du tableau</caption>      <!-- Optionnel -->
  <tr>                                      <!-- Ligne -->
    <th>En-tête 1</th>                      <!-- Cellule d'en-tête (gras, centré) -->
    <th>En-tête 2</th>
  </tr>
  <tr>
    <td>Donnée 1</td>                       <!-- Cellule de données -->
    <td>Donnée 2</td>
  </tr>
</table>
```

| Balise | Rôle |
|--------|------|
| `<table>` | Début/fin du tableau |
| `<tr>` | Ligne |
| `<th>` | Cellule d'en-tête (gras, centré) — optionnelle |
| `<td>` | Cellule de données |
| `<caption>` | Titre/légende du tableau — optionnelle |

### 6.2 Attributs de `<table>`

| Attribut | Rôle |
|----------|------|
| `border="n"` | Épaisseur des bordures |
| `cellpadding="n"` | Espace entre bord et contenu de la cellule |
| `cellspacing="n"` | Espace entre les cellules |
| `align="left\|center\|right"` | Position du tableau dans la page |
| `background="image"` | Image d'arrière-plan |
| `bgcolor="couleur"` | Couleur de fond |
| `bordercolor="couleur"` | Couleur des bordures |
| `bordercolordark="couleur"` | Couleur sombre de l'ombrage |
| `bordercolorlight="couleur"` | Couleur claire de l'ombrage |

### 6.3 Attributs de `<tr>`, `<th>`, `<td>`

| Attribut | Rôle |
|----------|------|
| `align="left\|center\|right"` | Alignement horizontal |
| `valign="top\|middle\|bottom"` | Alignement vertical |
| `bgcolor="couleur"` | Couleur de fond |
| `width="n"` / `height="n"` | Largeur / Hauteur (pixels ou %) |

### 6.4 Fusion de cellules ⭐

| Attribut | Effet |
|----------|-------|
| `colspan="n"` | Fusionne **n colonnes** horizontalement |
| `rowspan="n"` | Fusionne **n lignes** verticalement |

**Exemple :**
```html
<table border="2">
  <tr>
    <td rowspan="2">Fusion 2 lignes</td>
    <td colspan="2">Fusion 2 colonnes</td>
  </tr>
  <tr>
    <td>Cellule</td>
    <td>Cellule</td>
  </tr>
  <tr>
    <td>Cellule</td>
    <td>Cellule</td>
    <td>Cellule</td>
  </tr>
</table>
```

> ⚠️ Les fusions doivent être **cohérentes** par rapport aux lignes et colonnes du tableau.

---

## 7. Les formulaires

### 7.1 La balise `<form>`

```html
<form action="traitement.php" method="post">
  <!-- champs du formulaire -->
</form>
```

| Attribut | Rôle |
|----------|------|
| `action` | URL du fichier qui traite les données |
| `method` | `GET` (données dans l'URL) ou `POST` (données séparées) |

### 7.2 Les éléments de formulaire

3 éléments principaux : **INPUT**, **SELECT**, **TEXTAREA**

### 7.3 L'élément `<input>`

#### Types d'input

| Type | Usage | Exemple |
|------|-------|---------|
| `text` | Champ texte | `<input type="text" name="nom" size="25">` |
| `password` | Mot de passe (masqué) | `<input type="password" name="pass">` |
| `checkbox` | Case à cocher (choix multiples) | `<input type="checkbox" name="opt" value="x">` |
| `radio` | Bouton radio (choix unique) | `<input type="radio" name="choix" value="a">` |
| `file` | Envoi de fichier | `<input type="file" name="fichier">` |
| `hidden` | Champ caché | `<input type="hidden" name="id" value="123">` |
| `submit` | Bouton d'envoi | `<input type="submit" value="Envoyer">` |
| `reset` | Bouton de réinitialisation | `<input type="reset" value="Effacer">` |
| `button` | Bouton personnalisé | `<input type="button" value="Clic" onClick="fn()">` |
| `image` | Image cliquable | `<input type="image" src="btn.png">` |

#### Attributs d'input

| Attribut | Rôle |
|----------|------|
| `type` | Type du champ |
| `name` | Nom du champ (clé envoyée au serveur) |
| `value` | Valeur par défaut |
| `size` | Largeur visible du champ (en caractères) |
| `maxlength` | Nombre max de caractères (text/password) |
| `checked` | Pré-coché (radio/checkbox) |
| `placeholder` | Indication dans le champ (disparaît au clic) |

### 7.4 Le label `<label>`

Lie un libellé à un champ via `for` ↔ `id` :

```html
<label for="prenom">Votre prénom</label>
<input type="text" name="prenom" id="prenom">
```

### 7.5 L'élément `<textarea>`

Zone de texte multi-lignes :

```html
<textarea name="commentaires" rows="5" cols="40"></textarea>
```

| Attribut | Rôle |
|----------|------|
| `name` | Nom de la zone |
| `rows` | Nombre de lignes visibles |
| `cols` | Nombre de colonnes visibles |

### 7.6 L'élément `<select>` (Menu déroulant)

```html
<select name="platform">
  <option value="win64">Windows 10 ou 11</option>
  <option value="mac">Mac OS</option>
  <option value="linux" selected>Linux</option>
</select>
```

| Attribut de `<select>` | Rôle |
|------------------------|------|
| `name` | Nom du menu |
| `size` | Nombre de choix visibles |
| `multiple` | Permet la sélection multiple |

| Attribut de `<option>` | Rôle |
|------------------------|------|
| `value` | Valeur transmise au serveur |
| `selected` | Choix par défaut |

> Si `value` est absent, c'est le texte entre `<option>` et `</option>` qui est transmis.

### 7.7 Structurer un formulaire : `<fieldset>` et `<legend>`

```html
<fieldset>
  <legend>Informations personnelles</legend>
  Nom : <input type="text">
  Prénom : <input type="text">
</fieldset>
```

---

## 8. Aide-mémoire rapide — Balises essentielles

| Catégorie | Balises clés |
|-----------|-------------|
| **Structure** | `<!DOCTYPE>`, `<html>`, `<head>`, `<title>`, `<meta>`, `<body>` |
| **Texte** | `<b>`, `<i>`, `<em>`, `<u>`, `<font>`, `<big>`, `<small>` |
| **Titres** | `<h1>` … `<h6>` |
| **Paragraphes** | `<p>`, `<br>`, `<hr>` |
| **Listes** | `<ol>`, `<ul>`, `<li>`, `<dl>`, `<dt>`, `<dd>` |
| **Blocs** | `<div>`, `<span>`, `<center>`, `<blockquote>` |
| **Liens** | `<a href="">`, `<a name="">` |
| **Images** | `<img src="" alt="">` |
| **Tableaux** | `<table>`, `<tr>`, `<th>`, `<td>`, `<caption>` |
| **Formulaires** | `<form>`, `<input>`, `<textarea>`, `<select>`, `<option>`, `<label>`, `<fieldset>`, `<legend>` |

---

> 📖 *Résumé basé sur le cours de Pr. Abdelali Boushaba — Chapitre 2 : Le langage HTML*
