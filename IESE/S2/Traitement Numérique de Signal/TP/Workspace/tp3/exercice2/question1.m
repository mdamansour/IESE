h1 = [0.5, 0.5];           
yn = filter(h1, 1, xn);

figure;
plot(yn);
title('signal filtré');
xlabel('x');
ylabel('y');