function [y,n]=sigmult(x1,n1,x2,n2)
% fonction qui effectue la somme x1(n)+x2(n)
% Y est la somme à n échantillons qui comprend n1 et n2
% x1 est la première séquence de longueur n1
% x2 est la deuxième séquence de longueur n2 (peut être différente de n1)
n=min(min(n1),min(n2)):max(max(n1),max(n2))  % longueur de y
y1 = zeros(1,length(n)); y2=y1             %  initialisation
y1(find((n>=min(n1))&(n<=max(n1))==1))=x1;%remettre x1 à la longueur n de y
y2(find((n>=min(n2))&(n<=max(n2))==1))=x2;%remettre x2 à la longueur n de y
y=y1.*y2;
