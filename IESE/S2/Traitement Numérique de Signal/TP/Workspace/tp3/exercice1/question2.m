Rxx_biaise = xcorr(xn, 'biased');
Rxx_non_biaise = xcorr(xn, 'unbiased');

figure;

subplot(2,1,1);
stem(-N+1:N-1, Rxx_biaise); 
title('autocorrélation  biaisé');
xlabel('k');
ylabel('Amplitude');
grid on;

subplot(2,1,2);
stem(-N+1:N-1, Rxx_non_biaise);
title('autocorrélation non biaisé');
xlabel('k');
ylabel('Amplitude');
grid on;