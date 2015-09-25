%%
close all;
clear all;


%%

timeline = 1;
%templine =1;

M = dlmread('doblo.txt.txt', ' ');










%%

temp=M(:, 15:15);
M= M(:, 3:14);

MIN =0;
MAX= 4096;
MIN = min( min(M));
MAX = max( max(M));

%MAX = 2860;


%%
%%
if timeline == 1
figure(1);

subplot(4,3,1)
plot( M(:,1))
title('X 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,4)
plot( M(:,4))
title('X 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,7)
plot( M(:,7))
title('X 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,10)
plot( M(:,10))
title('X 4')
axis([-inf,inf,MIN, MAX])


subplot(4,3,2)
plot( M(:,2))
title('Y 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,5)
plot( M(:,5))
title('Y 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,8)
plot( M(:,8))
title('Y 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,11)
plot( M(:,11))
title('Y 4')
axis([-inf,inf,MIN, MAX])


subplot(4,3,3)
plot( M(:,3))
title('Z 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,6)
plot( M(:,6))
title('Z 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,9)
plot( M(:,9))
title('Z 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,12)
plot( M(:,12))
title('Z 4')
axis([-inf,inf,MIN, MAX])

end

%%
if templine ==1

figure(2);

subplot(4,3,1)
scatter(temp, M(:,1),'.')
title('X 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,4)
scatter(temp, M(:,4),'.')
title('X 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,7)
scatter(temp, M(:,7),'.')
title('X 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,10)
scatter(temp, M(:,10),'.')
title('X 4')
axis([-inf,inf,MIN, MAX])


subplot(4,3,2)
scatter(temp, M(:,2),'.')
title('Y 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,5)
scatter(temp, M(:,5),'.')
title('Y 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,8)
scatter(temp, M(:,8),'.')
title('Y 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,11)
scatter(temp, M(:,11),'.')
title('Y 4')
axis([-inf,inf,MIN, MAX])


subplot(4,3,3)
scatter(temp, M(:,3),'.')
title('Z 1')
axis([-inf,inf,MIN, MAX])

subplot(4,3,6)
scatter(temp, M(:,6),'.')
title('Z 2')
axis([-inf,inf,MIN, MAX])

subplot(4,3,9)
scatter(temp, M(:,9),'.')
title('Z 3')
axis([-inf,inf,MIN, MAX])

subplot(4,3,12)
scatter(temp, M(:,12),'.')
title('Z 4')
axis([-inf,inf,MIN, MAX])

end

