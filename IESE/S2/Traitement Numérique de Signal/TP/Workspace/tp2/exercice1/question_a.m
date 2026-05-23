fe = 1000;
fc = 300;
n = 9;

[b,a] = butter(n, fc*2*pi, 's');
figure(1)
freqs(b,a)
title('Butterworth - continue')
grid on

[bn,an] = butter(n, 0.3);
figure(2)
freqz(bn,an)
title('Butterworth - discret')
grid on