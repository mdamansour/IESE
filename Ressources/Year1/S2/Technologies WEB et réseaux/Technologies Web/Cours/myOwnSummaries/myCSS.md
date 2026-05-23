# My CSS Summary

## Introduction

## Selectors

## Properties

## Box Model

## Positioning

## Flexbox

## Grid

## Media Queries

## CSS Example: Styling `h3` and `p` Elements

The following CSS code demonstrates how to style `h3` and `p` elements with specific font properties, colors, and background:

```css
h3, p {
  font-family: Arial, Calibri, Verdana;
  font-style: italic;
  font-weight: bold;
  color: green;
  background-color: white;
}
```

### Explanation:
- **`font-family`**: Specifies the font stack, starting with Arial, followed by Calibri, and Verdana as fallbacks.
- **`font-style`**: Sets the text to italic.
- **`font-weight`**: Makes the text bold.
- **`color`**: Changes the text color to green.
- **`background-color`**: Sets the background color to white.

## CSS Operators

CSS operators are used in selectors to define relationships between elements. Below is a summary of the most common operators:

### 1. **Universal Selector (`*`):**
- Selects all elements in the document.
```css
* {
  color: red;
}
```

### 2. **Descendant Selector (Space):**
- Selects all elements that are descendants of a specified element.
```css
div p {
  color: blue;
}
```

### 3. **Child Selector (`>`):**
- Selects all elements that are direct children of a specified element.
```css
div > a {
  text-decoration: none;
}
```

### 4. **Adjacent Sibling Selector (`+`):**
- Selects the element that is immediately preceded by a specified element.
```css
i + p {
  color: blue;
}
```

### 5. **General Sibling Selector (`~`):**
- Selects all elements that are siblings of a specified element.
```css
i ~ p {
  color: blue;
}
```

### 6. **Attribute Selector:**
- Selects elements based on the presence or value of an attribute.
```css
input[type="text"] {
  border: 1px solid black;
}
```

### 7. **Grouping Selector (`,`)**
- Allows multiple selectors to share the same styles.
```css
h1, h2, p {
  color: blue;
  font-family: Arial, sans-serif;
}
```

### Explanation:
- **Universal Selector (`*`)**: Targets all elements.
- **Descendant Selector (Space)**: Targets nested elements.
- **Child Selector (`>`):** Targets direct children only.
- **Adjacent Sibling Selector (`+`)**: Targets the next sibling element.
- **General Sibling Selector (`~`)**: Targets all sibling elements.
- **Attribute Selector**: Targets elements with specific attributes.
- **Grouping Selector (`h1, h2, p`)**: Applies the same styles to `h1`, `h2`, and `p` elements, reducing redundancy and making the CSS more concise.

## CSS Operator Application Examples

This section provides practical examples for each CSS operator, showing when a style will apply and when it will not.

---

### 1. Universal Selector (`*`)

- **Applies**: The `*` selector targets every single element in the HTML document.
- **Doesn't Apply**: This selector is universal, so it always applies to all elements. There isn't a scenario where it wouldn't apply.

**CSS:**
```css
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
```
**HTML:**
```html
<div>This div has no margin or padding.</div>
<p>This paragraph also has no margin or padding.</p>
```

---

### 2. Descendant Selector (Space)

- **Applies**: `div p` targets any `<p>` element that is located anywhere inside a `<div>`.
- **Doesn't Apply**: It will not target a `<p>` element that is a sibling to a `<div>` or outside of it.

**CSS:**
```css
div p {
  color: green;
}
```
**HTML:**
```html
<div>
  <p>This text will be green.</p> <!-- Applies -->
  <span><p>This text will also be green.</p></span> <!-- Applies -->
</div>
<p>This text will NOT be green.</p> <!-- Does not apply -->
```

---

### 3. Child Selector (`>`)

- **Applies**: `div > p` targets only `<p>` elements that are direct children of a `<div>`.
- **Doesn't Apply**: It will not target `<p>` elements that are nested deeper inside other elements within the `<div>`.

**CSS:**
```css
div > p {
  color: blue;
}
```
**HTML:**
```html
<div>
  <p>This text will be blue.</p> <!-- Applies -->
  <span>
    <p>This text will NOT be blue.</p> <!-- Does not apply -->
  </span>
</div>
```

---

### 4. Adjacent Sibling Selector (`+`)

- **Applies**: `h1 + p` targets the first `<p>` element that immediately follows an `<h1>` element.
- **Doesn't Apply**: It will not target a `<p>` that is separated from the `<h1>` by another element or any `<p>` that comes before the `<h1>`.

**CSS:**
```css
h1 + p {
  font-weight: bold;
}
```
**HTML:**
```html
<h1>This is a heading</h1>
<p>This paragraph will be bold.</p> <!-- Applies -->
<p>This paragraph will not be bold.</p> <!-- Does not apply -->

<div>
  <h1>Another heading</h1>
  <h2>A subheading</h2>
  <p>This paragraph will NOT be bold because it's not adjacent.</p> <!-- Does not apply -->
</div>
```

---

### 5. General Sibling Selector (`~`)

- **Applies**: `h1 ~ p` targets all `<p>` elements that are siblings of an `<h1>` and appear after it.
- **Doesn't Apply**: It will not target siblings that appear *before* the `<h1>` or elements that are not siblings.

**CSS:**
```css
h1 ~ p {
  font-style: italic;
}
```
**HTML:**
```html
<p>This paragraph is not a sibling that comes after.</p> <!-- Does not apply -->
<h1>This is a heading</h1>
<p>This paragraph will be italic.</p> <!-- Applies -->
<div>This is not a sibling.</div>
<p>This paragraph will also be italic.</p> <!-- Applies -->
```

---

### 6. Attribute Selector (`[]`)

- **Applies**: `a[target="_blank"]` targets `<a>` elements that have a `target` attribute with the exact value `_blank`.
- **Doesn't Apply**: It will not target `<a>` elements without a `target` attribute or where the attribute value is different.

**CSS:**
```css
a[target="_blank"] {
  background-color: yellow;
}
```
**HTML:**
```html
<!-- Applies -->
<a href="#" target="_blank">This link opens in a new tab and will have a yellow background.</a>

<!-- Does not apply -->
<a href="#">This link will not have a yellow background.</a>
```

---

### 7. Grouping Selector (`,`)

- **Applies**: `h1, .special` targets all `<h1>` elements AND all elements with the class `special`.
- **Doesn't Apply**: It will not target any other elements, like an `<h2>` or a `<p>` without the `special` class.

**CSS:**
```css
h1, .special {
  border: 1px solid red;
}
```
**HTML:**
```html
<h1>This heading gets a border.</h1> <!-- Applies -->
<p class="special">This special paragraph gets a border.</p> <!-- Applies -->
<h2>This heading does NOT get a border.</h2> <!-- Does not apply -->
```
