N = 10;
M = 2 * N;

x = ones(1, N);
g = [0.7.^(0:M-1)]; 

y = convolution(x, g);

figure;
stem(y);
title('Convolution de x(n) et g(n)');
xlabel('n');
ylabel('y(n)');

length_y = length(y);
disp(['Length of y(n) = ', num2str(length_y)]);