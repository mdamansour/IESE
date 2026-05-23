clear all; close all; clc;

fc1 = 500 ; %Début de la BP
fc2 = 1000; %Fin de la BP

fe = 4000; %Fréquence d'échantillonnage

fc1N = fc1/(fe/2);
fc2N = fc2/(fe/2); %Normalisation de fc1 etfc2

NbCoeff = 47; %Nombre de coefficients
N=NbCoeff-1 ; %Ordre du filtre

h = fir1(N,[fc1N fc2N], 'band' ,rectwin(NbCoeff), 'scale' ) ;

[H F]= freqz(h, 1, 512, fe); % Calcul de H(f)

subplot(2,2,1);hold on; stem(h, 'b' ); grid; %Tracé de la réponse impulsionnelle,

subplot(2,2,2);hold on;plot(F,abs(H)); grid; %Tracé du spectre d'amplitude

subplot(2,2,3);hold on; plot(F,20*log10(abs(H))); grid %Tracé du spectre d'amplitude en db

subplot(2,2,4);hold on; zplane(h,1);grid; %Tracé des pôles et zéros