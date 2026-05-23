
function y = conv_fft(x, g)
    x = x(:)';
    g = g(:)';
    
    N = length(x) + length(g) - 1;
    X = fft(x, N);  
    G = fft(g, N);  
    
    Y = X .* G;
    
    y = ifft(Y);

    y = real(y); 
end