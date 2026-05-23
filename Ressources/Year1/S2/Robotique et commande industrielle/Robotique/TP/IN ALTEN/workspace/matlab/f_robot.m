function s = f_robot(e)
    % 1. System Parameters
    m = 1;      % Mass of the robot load
    g = 9.8;    % Gravity

    % 2. Map the Input Vector 'e'
    % The block receives 6 signals bundled together: 4 current states + 2 control inputs
    x1 = e(1);  % Radial position (r)
    x2 = e(2);  % Radial velocity (r_dot)
    x3 = e(3);  % Angular position (theta)
    x4 = e(4);  % Angular velocity (theta_dot)
    u1 = e(5);  % Control Force (F)
    u2 = e(6);  % Control Torque (T)

    % 3. Physics Equations (How the states change over time)
    dx1 = x2;
    dx2 = x1*x4^2 - g*sin(x3) + u1/m;
    dx3 = x4;
    dx4 = (-2*x1*x2*x4 - g*x1*cos(x3) + u2/m) / (x1^2);

    % 4. Output the changes
    s = [dx1; dx2; dx3; dx4];
end