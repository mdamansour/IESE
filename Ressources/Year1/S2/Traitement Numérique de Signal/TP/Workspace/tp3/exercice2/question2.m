moy_y = mean(yn);

[Rxy, k_xy] = xcorr(yn, xn, 'unbiased');
[Ryy, k_yy] = xcorr(yn, 'unbiased');

figure;

subplot(3,1,1);
stem(0, moy_y, '.');
title('Moyenne estimée non biaisée my');
xlabel('k');
ylabel('my');
xlim([-1 1]); 
grid on;

subplot(3,1,2);
stem(k_xy, Rxy, '.');
title('Intercorrélation estimée non biaisée Rxy(k)');
xlabel('k');
ylabel('Rxy');
xlim([-10 10]);
grid on;

subplot(3,1,3);
stem(k_yy, Ryy, '.');
title('Autocorrélation non biaisée Ryy(k)');
xlabel('k');
ylabel('Ryy');
xlim([-10 10]);
grid on;