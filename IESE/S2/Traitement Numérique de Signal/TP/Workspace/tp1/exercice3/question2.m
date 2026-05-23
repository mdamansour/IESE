N = 512; 
t = (0:N-1) / N;  
y = sin(2*pi*10*t) + sin(2*pi*15*t) + sin(2*pi*30*t);  


tic; 
y_dft = dft_signal(y); 
toc; 

tic;  
y_fft = fft(y); 
toc;  

figure;
subplot(2,1,1);
stem(abs(y_dft)); 
title('DFT (N = 512)');
xlabel('Frequence (k)');
ylabel('Amplitude');

subplot(2,1,2);
stem(abs(y_fft)); 
title('FFT (N = 512)');
xlabel('Frequence (k)');
ylabel('Amplitude');

N2 = 2048; 
t2 = (0:N2-1) / N2; 
y2 = sin(2*pi*10*t2) + sin(2*pi*15*t2) + sin(2*pi*30*t2); 

tic;
y2_dft = dft_signal(y2);  
toc; 

tic;  
y2_fft = fft(y2);
toc;

figure;
subplot(2,1,1);
stem(abs(y2_dft)); 
title('DFT (N = 2048)');
xlabel('Frequence (k)');
ylabel('Amplitude');

subplot(2,1,2);
stem(abs(y2_fft)); 
title('FFT (N = 2048)');
xlabel('Frequence (k)');
ylabel('Amplitude');