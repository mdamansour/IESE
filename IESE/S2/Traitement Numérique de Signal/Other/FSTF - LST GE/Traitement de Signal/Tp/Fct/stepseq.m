function [x,n]=stepseq(n0,n1,n2)
% génère le signal x(n)=u(n-n0) (échelon) pour n1<n<n2  
n=[n1:n2];
x=[(n-n0)>=0];
