N=4;
M=10;
d = [1, zeros(1, N-1)];

d_shifted = [zeros(1, N-1), 1, zeros(1, M-1)];

N = 512;
t = (0:N-1) / N;
signal = sin(2*pi*10*t) + sin(2*pi*15*t) + sin(2*pi*30*t);

N2 = 2 * N;
t2 = (0:N2-1) / N2;
signal2 = sin(2*pi*10*t2) + sin(2*pi*15*t2) + sin(2*pi*30*t2);

[y, fs] = audioread('SCHUBERT.WAV');
N_wav = 1024;
signal_wav = y(1:N_wav);  

d_dft = dft_signal(d);
d_shifted_dft = dft_signal(d_shifted);
signal_dft = dft_signal(signal);
signal2_dft = dft_signal(signal2);
X_wav = dft_signal(signal_wav); 


figure;

subplot(2,2,1);
stem(abs(d_dft));  
title('DFT de Dirac');
xlabel('Frequence (k)');
ylabel('Amplitude');

subplot(2,2,2);
stem(abs(d_shifted_dft));  
title('DFT de Dirac décalée');
xlabel('Frequence (k)');
ylabel('Amplitude');

subplot(2,2,3);
stem(abs(signal_dft));  
title('DFT de somme de trois sin (N = 512)');
xlabel('Frequence (k)');
ylabel('Amplitude');

subplot(2,2,4);
stem(abs(signal2_dft)); 
title('DFT de somme de trois sin (2N = 1024)');
xlabel('Frequence (k)');
ylabel('Amplitude');


figure;

stem(abs(X_wav));  
title('DFT de wav');
xlabel('Frequence (k)');
ylabel('Amplitude');