function Calculer() {
    var a = document.getElementById("n1").value;

    var b = document.getElementById("n2").value;

    var op = document.getElementById("operation").value

    var resultat;

    switch (op) {
        case "+":
            resultat = Number(a) + Number(b);
            break;

        case "-":  
            resultat = a - b; 
            break;

        case "*":   
            resultat = a * b;
            break;

        case "/":
            resultat = a / b;
            break;
    }

    document.getElementById("resultat").innerHTML = resultat;
}