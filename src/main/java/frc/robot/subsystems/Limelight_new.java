package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight_new extends SubsystemBase{
    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry aprilID = table.getEntry("tid");
    private static NetworkTableEntry botpose = table.getEntry("botpose");
    private static NetworkTableEntry bot_limelight = table.getEntry("targetpose_robotspace");
    private static Chasis chasis = new Chasis();
    

    int a = 0;
    public static double[] getrobot_limelight(){
        double[] pose = bot_limelight.getDoubleArray(new double[6]);
        return pose;
    }
    
    public static double getAprilID(){
        double a_ID = aprilID.getDouble(-1);
        return a_ID;
    }
    
    public void rotation(){
        double[] LMG = Limelight_new.getrobot_limelight();
        SmartDashboard.putNumber("horses", Limelight_new.getAprilID());
        SmartDashboard.putNumberArray("Position", LMG);
        SmartDashboard.putNumber("HZ", LMG[2]);
        if (LMG[2] > 0.5){
            if (LMG[0] > 0.1){
                chasis.lime_left();
            }
            else if (LMG[0] >= -0.1 && LMG[0] <= 0.1){
                chasis.lime_stop();
            }
            else if  (LMG[0] < -0.1){
                chasis.lime_right();
            }
        }
        else if(LMG[0] < -0.1 && a < 800|| LMG[0] > 0.1 && a < 800){
            chasis.lime_back();
            a++;
        }
        else {
            chasis.lime_stop();
            int a = 0;
        }
    }

    // public void auto(boolean LMGB){
    //     if (LMGB){
    //         double[] LMG = Limelight_new.getrobot_limelight();
    //         SmartDashboard.putNumber("horses", Limelight_new.getAprilID());
    //         SmartDashboard.putNumberArray("Position", LMG);
    //         SmartDashboard.putNumber("HZ", LMG[2]);
    //         if (LMG[2] > 0.75){
    //             chasis.lime_move();
    //             aaa();
    //         } 
    //         else if (LMG[2] <= 0.75 && LMG[2] >= 0.6){
    //             chasis.lime_stop();
    //             if (LMG[0] >= -0.1 && LMG[0] <= 0.1){
    //                 chasis.lime_stop();
    //             }

    //             else {
    //                 aaa();
    //             }
    //         }
    //         else if (LMG[2] < 0.6){
    //             chasis.lime_back();
    //             aaa();
    //         }
    //     }
    // }
    // public static double getdistance(){
    //     double distance = 
    // }

    @Override
    public void periodic(){
    }   
}