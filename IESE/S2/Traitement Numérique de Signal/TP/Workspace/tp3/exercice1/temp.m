% Initialisation des vecteurs pour stocker les estimations
moy_L = zeros(1, N);
var_L = zeros(1, N);

% Calcul de la moyenne et de la variance pour chaque longueur L
for L = 1:N
    x_L = xn(1:L); % Extraction des L premiers termes
    moy_L(L) = mean(x_L);
    
    % Pour L=1, la variance n'est pas définie (division par 0 si non biaisée),
    % on utilise l'estimateur biaisé (var(..., 1)) ou on met 0.
    if L == 1
        var_L(L) = 0;
    else
        var_L(L) = var(x_L); 
    end
end

% Tracé de l'évolution des estimateurs
figure;

% Tracé de la moyenne
subplot(2,1,1);
plot(1:N, moy_L, 'b');
yline(0, 'r--', 'LineWidth', 1.5); % Ligne théorique (moyenne = 0)
title('Evolution de l''estimateur de la moyenne');
xlabel('L');
ylabel('Moyenne');
grid on;

% Tracé de la variance
subplot(2,1,2);
plot(1:N, var_L, 'b');
yline(v, 'r--', 'LineWidth', 1.5); % Ligne théorique (variance = v = 10)
title('Evolution de l''estimateur de la variance');
xlabel('L');
ylabel('Variance');
grid on;