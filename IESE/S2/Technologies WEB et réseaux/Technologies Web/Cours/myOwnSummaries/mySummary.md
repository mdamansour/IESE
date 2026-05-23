# mySummary

### Tag `<hr>`

Inserts a horizontal line to separate sections.

#### Syntaxe :
```html
<hr>
```

#### Attributes :
| Attribute | Description |
|----------|-------------|
| `size`   | Thickness of the line |
| `width`  | Length of the line (in pixels or percentage) |
| `align`  | Alignment of the line (left, center, right) |
| `noshade`| Removes the shadow effect |

#### Example :
```html
<p>Text before the line</p>
<hr size="4" width="50%" align="center">
<p>Text after the line</p>
```

### Tag `<font>`

Styles text color, size, and font family.

#### Example :
```html
<font color="red" size="5" face="Arial">
This text is red, large, and written in Arial font.
</font>
```

### Tag `<em>`

Emphasizes text (usually shown in italic).

#### Example :
```html
<em>thing</em>
```

### Background and Text Colors

Set background, text, and link colors using `<body>` attributes.

- `bgcolor="#RRVVBB"`: Sets the background color of the page.
- `text="#RRVVBB"`: Sets the color of the text.
- `link="#RRVVBB"`: Sets the color of unvisited links.
- `vlink="#RRVVBB"`: Sets the color of visited links.
- `alink="#RRVVBB"`: Sets the color of active links (when clicked).
- `background="image.gif"`: Sets an image as the background of the page.

**Example:**

```html
<body bgcolor="#FFCC00" text="#000000" link="#0000FF" vlink="#800080" alink="#FF0000" background="image.gif">
  Content goes here
</body>
```

### Text Alignment

Defines text alignment within a block.

**Example:**
```html
<p align="left">Left aligned (default)</p>
<p align="center">Center aligned</p>
<p align="right">Right aligned</p>
<p align="justify">Justified text</p>
```

### Ordered List `<ol>`

Creates a numbered list of items.

**Types of Ordered Lists:**
- `type="1"`: Default numbering with Arabic numerals (1, 2, 3, ...).
- `type="A"`: Uppercase letters (A, B, C, ...).
- `type="a"`: Lowercase letters (a, b, c, ...).
- `type="I"`: Uppercase Roman numerals (I, II, III, ...).
- `type="i"`: Lowercase Roman numerals (i, ii, iii, ...).

**Example:**
```html
<ol>
  <li>Introduction</li>
  <li>Formatting</li>
  <li>Images</li>
  <li>Tips and Tricks</li>
</ol>

<!-- Custom numbering and type -->
<ol type="A" start="6">
  <li>Custom Item 6</li>
  <li>Custom Item 7</li>
</ol>
```

### Unordered List `<ul>`

Creates a bulleted list of items.

**Example:**
```html
<ul>
  <li>Introduction</li>
  <li>Formatting</li>
  <li>Images</li>
  <li>Tips and Tricks</li>
</ul>

<!-- Custom bullet style -->
<ul style="list-style-image:url(note.gif)">
  <li>Custom Bullet 1</li>
  <li>Custom Bullet 2</li>
</ul>

<!-- Different bullet types -->
<ul>
  <li type="disc">Disc Bullet</li>
  <li type="circle">Circle Bullet</li>
  <li type="square">Square Bullet</li>
</ul>
```

### Image Tag `<img>`

Inserts an image into the page with optional attributes for styling.

**Attributes:**
- `src`: Path to the image file.
- `title`: Tooltip text displayed on hover.
- `border`: Sets the border size around the image.
- `vspace`: Vertical space between the image and surrounding text.
- `hspace`: Horizontal space between the image and surrounding text.
- `align`: Aligns the image (e.g., `left`, `right`, `top`, `middle`, etc.).
- `width`: Width of the image in pixels.
- `height`: Height of the image in pixels.
- `alt`: Text displayed if the image cannot load.
- `name`: Name identifier for the image.

**Example:**
```html
<img src="image.jpg" border="1" width="200" height="100" alt="Description of the image">
```

### Table Tag `<table>`

Creates a table to organize data into rows and columns.

**Elements:**
- `<table>`: Marks the start and end of a table.
- `<tr>`: Defines a table row.
- `<th>`: Defines a header cell (centered, bold; optional).
- `<td>`: Defines a data cell.
- `<caption>`: Adds a title to the table (optional).

**Attributes:**
- `border="1"`: Sets the border width of the table.
- `cellpadding="n"`: Adds space (in pixels) between the cell content and its border.
- `cellspacing="n"`: Adds space (in pixels) between table cells.
- `align="left|center|right"`: Aligns the table within the page.

**Example:**
```html
<table border="1" cellpadding="5" cellspacing="10" align="center">
  <caption>Table Title</caption>
  <tr>
    <th>Header 1</th>
    <th>Header 2</th>
  </tr>
  <tr>
    <td>Data 1</td>
    <td>Data 2</td>
  </tr>
</table>
```

### Form Tag `<form>`

Defines a form for collecting user input and submitting it to a server.

**Attributes:**
- `action`: Specifies the URL where the form data will be sent.
- `method`: Defines the HTTP method for sending data (`GET` or `POST`).

**Example:**
```html
<html>
<head>
  <title>Form Example</title>
</head>
<body>
  <form action="url" method="POST">
    <textarea name="commentaires" rows="5" cols="40"></textarea>
    <input type="submit">
  </form>
</body>
</html>
```

### Select Tag `<select>`

Creates a dropdown menu or a list of options for user selection.

**Attributes:**
- `name`: Specifies the name of the dropdown menu.
- `size`: Defines the number of visible options.
- `multiple`: Allows multiple selections if present.

**Option Attributes:**
- `value`: Specifies the value sent to the server when selected.
- `selected`: Marks an option as the default selection.

**Example:**
```html
<select name="choices">
  <option value="option1">Option 1</option>
  <option value="option2" selected>Option 2</option>
  <option value="option3">Option 3</option>
</select>
```
