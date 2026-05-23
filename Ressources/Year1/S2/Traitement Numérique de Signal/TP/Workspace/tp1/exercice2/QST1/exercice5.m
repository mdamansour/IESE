N = 3;  
M = 6;  

f = exp(0.1 * (0:N-1));  
h = exp(-0.1 * (0:M-1));  

f_avec_zeros = [f, zeros(1, M-1)];  
h_avec_zeros = [h, zeros(1, N-1)];  

Y = conv_fft(f_avec_zeros, h_avec_zeros);

figure;
stem(0:length(Y)-1, Y);
title('Convolution lineaire de f(n) et h(n) par FFT');
xlabel('n');
ylabel('y(n)');