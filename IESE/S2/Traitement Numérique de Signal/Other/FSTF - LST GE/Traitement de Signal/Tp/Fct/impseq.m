function [x,n] = impseq(n0,n1,n2)
% g?n?re une signal x Dirac pour n1<n<n2 et qui vaut 1 en n0
n=[n1:n2];
x=[(n-n0)==0];
