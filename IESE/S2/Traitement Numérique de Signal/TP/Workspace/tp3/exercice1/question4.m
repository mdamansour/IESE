moyenne = zeros(1, N);
variance = zeros(1, N);

for L = 1:N
    x_L = xn(1:L); 
    moyenne(L) = mean(x_L);
    
    if L == 1
        variance(L) = 0;
    else
        variance(L) = var(x_L); 
    end
end

figure;

subplot(2,1,1);
plot(1:N, moyenne, 'b');
title('Evolution de l''estimateur de la moyenne');
xlabel('L');
ylabel('Moyenne');
grid on;

subplot(2,1,2);
plot(1:N, variance, 'b');
title('Evolution de l''estimateur de la variance');
xlabel('L');
ylabel('Variance');
grid on;