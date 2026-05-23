


function y = convolution(x, g)

    g = fliplr(g);  
    y = zeros(1, length(x) + length(g) - 1); % creates a row pre allocated with zeros juste pour faire espace pour l'occuper apres

    for n = 1:length(y) % pour chaque element dans le ligne

        for m = 1:length(g) %pour chaque echantillon dans le signale flippé

            if (n - m + 1 > 0) && (n - m + 1 <= length(x))
                y(n) = y(n) + x(n - m + 1) * g(m);
            end

        end

    end

end