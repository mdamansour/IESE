function s = f_commande(e)
    % 1. System & Tuning Parameters
    lamda1 = 3; lamda2 = 3; K1 = 4; K2 = 4;
    m = 1; g = 9.8;
    
    % 2. Map the Inputs
    % States (current position/speed)
    x1 = e(1); x2 = e(2); x3 = e(3); x4 = e(4);
    
    % Desired references (where we want the robot to go)
    y1r = e(5);  
    y2r = e(6);  
    
    % Derivatives of references (0 because they are constant step inputs)
    dy1r = 0; ddy1r = 0;
    dy2r = 0; ddy2r = 0;
    
    % 3. Calculate Sliding Surfaces
    % Surface 1 (Radial)
    y1 = x1; dy1 = x2;
    e1 = y1 - y1r; de1 = dy1 - dy1r;
    sigma1 = de1 + lamda1*e1;
    
    % Surface 2 (Angular)
    y2 = x3; dy2 = x4;
    e2 = y2 - y2r; de2 = dy2 - dy2r;
    sigma2 = de2 + lamda2*e2;
    
    % 4. Control Laws (The heavy math that calculates the force)
    u1 = m * (-x1*x4^2 + g*sin(x3) + ddy1r - lamda1*de1 - K1*sign(sigma1));
    u2 = m * (x1^2) * (-(-2*x1*x2*x4 - g*x1*cos(x3))/(x1^2) + ddy2r - lamda2*de2 - K2*sign(sigma2));
    
    % 5. Output the control signals and surface data
    s = [u1; u2; sigma1; sigma2];
end