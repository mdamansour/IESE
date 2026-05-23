fe = 1000;
fc = 300;
Rp = 3;
Rs = 50;

[be,ae] = ellip(9,Rp,Rs,fc*2*pi,'s');
figure(3)
freqs(be,ae)
title('Elliptique - continue')
grid on

[ben,aen] = ellip(9,Rp,Rs,fc/(fe/2));
figure(4)
freqz(ben,aen)
title('Elliptique - digital')
grid on