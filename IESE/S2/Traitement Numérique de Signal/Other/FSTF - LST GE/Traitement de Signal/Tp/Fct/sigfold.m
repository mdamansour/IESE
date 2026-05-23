function  [y,ny] = sigfold(x,n)
% implements y(ny) = x(-n)

ny = n; y = fliplr(x);
