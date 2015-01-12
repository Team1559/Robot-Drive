/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;



import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot2013 extends IterativeRobot 
{
    private final int LEFTMOTOR = 1;
    private final int RIGHTMOTOR = 10;
    private Compressor c;
    private int a;
    private boolean lickersIn = true;
    private Talon right;
    private Talon left;
    private Joystick joy;
    private RobotDrive drive;
    private Solenoid sol1;
    private Solenoid sol2;
    private boolean theTruth = true;
    private final int button = 1;
    private boolean flag = true;
    private double dist = 3.14/2;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
        joy = new Joystick(1);
        a = 1;
        System.out.println("robotInit");
        try {
            right = new Talon(RIGHTMOTOR);
            left = new Talon(LEFTMOTOR);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        sol1 = new Solenoid(1);
        sol2 = new Solenoid(2);
        c = new Compressor(8,1);
        c.start();
        sol1.set(false);
        sol2.set(true);
        
        /*drive = new RobotDrive(left, right);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        */
    }  //  robotInit

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit()
    {
        a=1;
        System.out.println("autonomousInit");
        /*try {
            right.changeControlMode(CANJaguar.ControlMode.kPosition);
            left.changeControlMode(CANJaguar.ControlMode.kPosition);
            right.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            left.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            right.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            left.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            right.configEncoderCodesPerRev(360);
            left.configEncoderCodesPerRev(360);
            right.enableControl();
            left.enableControl();
            right.setPID(.02, 0.05, 0.05);
            left.setPID(.02, 0.05, 0.05);
            right.setX(-dist);
            left.setX(dist);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }*/
            
    }   //  autonomousInit

    /**
     * This function is called periodically during operator control
     */
    double var1;
    double var2;
    
    public void autonomousPeriodic() 
    {
        
        if (a==1)
        {
            System.out.println("autonomousPeriodic");
            a++;
        }
        
    }   //  autonomousPeriodic

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit() 
    {
        a=1;
        System.out.println("teleopInit");
        //right = new CANJaguar(6);
        //left = new CANJaguar(7);
    }   //  teleopInit
    
    /**
     * This function is called periodically during test mode
     */
    double lft;
    double rgt;
    public void teleopPeriodic() 
    {
        if (a==1)
        {
            System.out.println("teleopPeriodic");
            a++;
        }
        if (joy.getY() > 0.0) {
            if (joy.getX() > 0.0) {
                lft = joy.getY() - joy.getX();
                rgt = Math.max(joy.getY(), joy.getX());
            } else {
                lft = Math.max(joy.getY(), -joy.getX());
                rgt = joy.getY() + joy.getX();
            }
        } else {
            if (joy.getX() > 0.0) {
                lft = -Math.max(-joy.getY(), joy.getX());
                rgt = joy.getY() + joy.getX();
            } else {
                lft = joy.getY() - joy.getX();
                rgt = -Math.max(-joy.getY(), -joy.getX());
            }
        }
        left.set(-lft);
        right.set(rgt);
       
       /*if (joy.getRawButton(button) && lickersIn && theTruth) //Makes "tongue" go out
       {
           lickerout.set(true);
           lickerin.set(false);
           lickersIn = false;
           theTruth = false;
       }
       else if (joy.getRawButton(button) && !lickersIn && theTruth) //Makes "tongue" go in
       {
           lickerout.set(false);
           lickerin.set(true);
           lickersIn = true;
           theTruth = false;
       }
       else if (!joy.getRawButton(button))
           theTruth = true;*/
        
       
        
    }   //  teleopPeriodic
    
    /**
     * This function is called periodically during test mode
     */
    public void testInit() 
    {
        
        a=1;
        System.out.println("testInit");
    }   //  testInit
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        
        if (a==1)
        {
            System.out.println("testPeriodic");
            a++;
        }
    }   //  testPeriodic
    /**
     * This function is called periodically during test mode
     */
    public void disabledInit() 
    {
        a = 1;
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