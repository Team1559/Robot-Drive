/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot 
{
    private final int PSENSOR = 3;
    
    AnalogChannel psensor;
    int a = 1;
    Talon left;
    Talon right;
    RobotDrive hotRod;
    Joystick joyous;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
        left = new Talon(1);
        right = new Talon(2);
        hotRod = new RobotDrive(left, right);
        joyous = new Joystick(1);
    }   //  robotInit

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit() 
    {

    }   //  autonomousInit

    /**
     * This function is called periodically during operator control
     */
    public void autonomousPeriodic() 
    {

    }   //  autonomousPeriodic

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit() 
    {
        
    }   //  teleopInit
    
    /**
     * This function is called periodically during test mode
     */
    public void teleopPeriodic() 
    {
        hotRod.arcadeDrive(joyous);
    }   //  teleopPeriodic
    
    /**
     * This function is called periodically during test mode
     */
    public void testInit() 
    {
    
    }   //  testInit
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    
    }   //  testPeriodic\
    /**
     * This function is called periodically during test mode
     */
    public void disabledInit() 
    {
        System.out.println("disabledInit");
        
    }   //  disabledInit
    /**
     * This function is called periodically during test mode
     */
    public void disabledPeriodic() 
    {
        if (a==1)
        {
            System.out.println("disabledPeriodic");
            a++;
        }
        
        
    }   //  disabledPeriodic
    
}