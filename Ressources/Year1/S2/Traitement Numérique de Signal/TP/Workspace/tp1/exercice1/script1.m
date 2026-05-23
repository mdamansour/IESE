s = audioread('SCHUBERT.WAV');
size(s); length(s);
min(s); max(s);
s = s(1:1024);
plot(s), title('Signal Initial')


function Sres = quantlin(s, B)
    J = 2^B;
    q = 2 / J;
    j = floor(s / q);
    Sres = q .* (j + 1/2);

    subplot(2,1,1);
    plot(s);
    title('Signal Original');

    subplot(2,1,2);
    plot(Sres);
    title('Signal Quantifié');
end

Sres = quantlin(s, 3);



function testlin(s,B)

    N = length(s);
    Sres = quantlin(s,B);
    bq = s - Sres;
    e = (1/N)*sum(bq.^2);
    
    figure
    plot(bq)
    title(['Bruit de quantification = ',num2str(B)])
    
    disp(['Puissance de erreur = ',num2str(e)])

end

testlin(s,3)





N = 10; 
M = 2*N; 

x = ones(1, N); 
g = 0.7 .^ (0:M-1);  

y = conv(x, g); 




function y = conv_signal(x, g)
    g = fliplr(g);
    y = conv(x, g);
    figure
    plot(y)
    title('Convolution de x et g)')
end

conv_signal(x, g);