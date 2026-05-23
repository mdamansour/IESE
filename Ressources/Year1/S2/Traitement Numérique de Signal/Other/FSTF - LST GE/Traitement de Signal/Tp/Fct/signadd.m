function [y,n]=signadd(x1,n1,x2,n2)
% fonction qui effectue la somme x1(n)+x2(n)
% Y est la somme ? n ?chantillons qui comprend n1 et n2
% x1 est la premi?re s?quence de longueur n1
% x2 est la deuxi?me s?quence de longueur n2 (peut ?tre diff?rente de n1)
n=min(min(n1),min(n2)):max(max(n1),max(n2));  % longueur de y
y1 = zeros(1,length(n)); y2=y1   ;          %  initialisation
y1(find((n>=min(n1))&(n<=max(n1))==1))=x1;%remettre x1 ? la longueur n de y
y2(find((n>=min(n2))&(n<=max(n2))==1))=x2;%remettre x2 ? la longueur n de y
y=y1+y2;
