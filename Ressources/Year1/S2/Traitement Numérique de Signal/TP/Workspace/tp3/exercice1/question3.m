XF = fft(xn);

DSP = (abs(XF).^2) / N;

f = (0:N-1) / N;

figure;
plot(f, DSP);
title('DSP en utilisabt la FFT');
xlabel('f');
ylabel('DSP');
grid on;