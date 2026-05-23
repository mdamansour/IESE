a = 0.75;
a2 = [1, -a];  %derna -a 7it bghina ykon fe dénominateur ykon (1-a.Z-1) 

yn = filter(1, a2, xn);

k = -20:20;
Ryy_theorique = a.^abs(k);

figure;
stem(k, Ryy_theorique, '.');
title('Autocorrélation théorique');
xlabel('k');
ylabel('Ryy théorique');
grid on;