function testlin(s,B)

    N = length(s);
    Sres = quantlin(s,B);
    bq = s - Sres;
    e = (1/N)*sum(bq.^2);
    
    figure
    plot(bq)
    title(['Bruit de quantification = ',num2str(B)])
    
    disp(['Puissance errekur = ',num2str(e)])

end

testlin(s,4)
