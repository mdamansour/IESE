N = 2048; 
v = 10; 

xn = normrnd(0, v, 1, N); 

figure;
plot(xn);
title('Bruit Blanc x(n)');
xlabel('n');
ylabel('xn');