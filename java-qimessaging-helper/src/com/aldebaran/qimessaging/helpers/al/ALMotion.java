package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALMotion extends ALModule {

    public ALMotion(Session session) {
        super(session);
    }

    /**
     * 100 exit                           Void ()
     * Exits and unregisters the module.
     * 102 pCall                          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                           Void (Int32)
     * returns true if the method is currently running
     * id: the ID of the method to wait for
     */
    public void stop(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stop", param1);
        else
            service.call("stop", param1).get();
    }

    /**
     * 111 getBrokerName                  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 wakeUp                         Void ()
     * The robot will wake up: set Motor ON and go to initial position if needed
     */
    public void wakeUp() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wakeUp");
        else
            service.call("wakeUp").get();
    }

    /**
     * 114 rest                           Void ()
     * The robot will rest: go to a relax and safe position and set Motor OFF
     */
    public void rest() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("rest");
        else
            service.call("rest").get();
    }

    /**
     * 115 rest                           Void (String)
     * The robot will rest: go to a relax and safe position on the chain and set Motor OFF
     */
    public void rest(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("rest", param1);
        else
            service.call("rest", param1).get();
    }

    /**
     * 122 robotIsWakeUp                  Bool ()
     * return true if the robot is already wakeUp
     * return: True if the robot is already wakeUp.
     */
    public Boolean robotIsWakeUp() throws CallError, InterruptedException {
        return (Boolean) service.call("robotIsWakeUp").get();
    }

    /**
     * 123 stiffnessInterpolation         Void (Value,Value,Value)
     * Interpolates one or multiple joints to a target stiffness or along timed trajectories of stiffness. This is a blocking call.
     * names: Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * stiffnessLists: An stiffness, list of stiffnesses or list of list of stiffnesses
     * timeLists: A time, list of times or list of list of times.
     */
    public void stiffnessInterpolation(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stiffnessInterpolation", param1, param2, param3);
        else
            service.call("stiffnessInterpolation", param1, param2, param3).get();
    }

    /**
     * 124 setStiffnesses                 Void (Value,Value)
     * Sets the stiffness of one or more joints. This is a non-blocking call.
     * names: Names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * stiffnesses: One or more stiffnesses between zero and one.
     */
    public void setStiffnesses(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setStiffnesses", param1, param2);
        else
            service.call("setStiffnesses", param1, param2).get();
    }

    /**
     * 126 getStiffnesses                 List<Float> (Value)
     * Gets stiffness of a joint or group of joints
     * jointName: Name of the joints, chains, "Body", "Joints" or "Actuators".
     * return: One or more stiffnesses. 1.0 indicates maximum stiffness. 0.0 indicated minimum stiffness
     */
    public List<Float> getStiffnesses(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getStiffnesses", param1).get();
    }

    /**
     * 127 angleInterpolation             Void (Value,Value,Value,Bool)
     * Interpolates one or multiple joints to a target angle or along timed trajectories. This is a blocking call.
     * names: Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * angleLists: An angle, list of angles or list of list of angles in radians
     * timeLists: A time, list of times or list of list of times in seconds
     * isAbsolute: If true, the movement is described in absolute angles, else the angles are relative to the current angle.
     */
    public void angleInterpolation(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("angleInterpolation", param1, param2, param3, param4);
        else
            service.call("angleInterpolation", param1, param2, param3, param4).get();
    }

    /**
     * 128 angleInterpolationWithSpeed    Void (Value,Value,Float)
     * Interpolates one or multiple joints to a target angle, using a fraction of max speed. Only one target angle is allowed for each joint. This is a blocking call.
     * names: Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * targetAngles: An angle, or list of angles in radians
     * maxSpeedFraction: A fraction.
     */
    public void angleInterpolationWithSpeed(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("angleInterpolationWithSpeed", param1, param2, param3);
        else
            service.call("angleInterpolationWithSpeed", param1, param2, param3).get();
    }

    /**
     * 129 angleInterpolationBezier       Void (List<String>,Value,Value)
     * Interpolates a sequence of timed angles for several motors using bezier control points. This is a blocking call.
     * jointNames: A vector of joint names
     * times: An ragged ALValue matrix of floats. Each line corresponding to a motor, and column element to a control point.
     * controlPoints: An ALValue array of arrays each containing [float angle, Handle1, Handle2], where Handle is [int InterpolationType, float dAngle, float dTime] descibing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceeding the point, the second describes the curve following the point.
     */
    public void angleInterpolationBezier(List<String> param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("angleInterpolationBezier", param1, param2, param3);
        else
            service.call("angleInterpolationBezier", param1, param2, param3).get();
    }

    /**
     * 130 setAngles                      Void (Value,Value,Float)
     * Sets angles. This is a non-blocking call.
     * names: The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * angles: One or more angles in radians
     * fractionMaxSpeed: The fraction of maximum speed to use
     */
    public void setAngles(String param1, List<Float> param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setAngles", param1, param2, param3);
        else
            service.call("setAngles", param1, param2, param3).get();
    }

    /**
     * 131 changeAngles                   Void (Value,Value,Float)
     * Changes Angles. This is a non-blocking call.
     * names: The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * changes: One or more changes in radians
     * fractionMaxSpeed: The fraction of maximum speed to use
     */
    public void changeAngles(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("changeAngles", param1, param2, param3);
        else
            service.call("changeAngles", param1, param2, param3).get();
    }

    /**
     * 132 getAngles                      List<Float> (Value,Bool)
     * Gets the angles of the joints
     * names: Names the joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
     * useSensors: If true, sensor angles will be returned
     * return: Joint angles in radians.
     */
    public List<Float> getAngles(String param1, Boolean param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getAngles", param1, param2).get();
    }

    /**
     * 133 openHand                       Void (String)
     * NAO stiffens the motors of desired hand. Then, he opens the hand, then cuts motor current to conserve energy. This is a blocking call.
     * handName: The name of the hand. Could be: "RHand or "LHand"
     */
    public void openHand(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("openHand", param1);
        else
            service.call("openHand", param1).get();
    }

    /**
     * 134 closeHand                      Void (String)
     * NAO stiffens the motors of desired hand. Then, he closes the hand, then cuts motor current to conserve energy. This is a blocking call.
     * handName: The name of the hand. Could be: "RHand" or "LHand"
     */
    public void closeHand(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("closeHand", param1);
        else
            service.call("closeHand", param1).get();
    }

    /**
     * 135 move                           Void (Float,Float,Float)
     * Makes the robot move at the given velocity. This is a non-blocking call.
     * x: The velocity along x axis [m.s-1].
     * y: The velocity along y axis [m.s-1].
     * theta: The velocity around z axis [rd.s-1].
     */
    public void move(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("move", param1, param2, param3);
        else
            service.call("move", param1, param2, param3).get();
    }

    /**
     * 136 move                           Void (Float,Float,Float,Value)
     * Makes the robot move at the given velocity. This is a non-blocking call.
     * x: The velocity along x axis [m.s-1].
     * y: The velocity along y axis [m.s-1].
     * theta: The velocity around z axis [rd.s-1].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void move(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("move", param1, param2, param3, param4);
        else
            service.call("move", param1, param2, param3, param4).get();
    }

    /**
     * 137 moveToward                     Void (Float,Float,Float)
     * Makes the robot move at the given normalized velocity. This is a non-blocking call.
     * x: The normalized velocity along x axis (between -1 and 1).
     * y: The normalized velocity along y axis (between -1 and 1).
     * theta: The normalized velocity around z axis (between -1 and 1).
     */
    public void moveToward(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveToward", param1, param2, param3);
        else
            service.call("moveToward", param1, param2, param3).get();
    }

    /**
     * 138 moveToward                     Void (Float,Float,Float,Value)
     * Makes the robot move at the given normalized velocity. This is a non-blocking call.
     * x: The normalized velocity along x axis (between -1 and 1).
     * y: The normalized velocity along y axis (between -1 and 1).
     * theta: The normalized velocity around z axis (between -1 and 1).
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveToward(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveToward", param1, param2, param3, param4);
        else
            service.call("moveToward", param1, param2, param3, param4).get();
    }

    /**
     * 139 setWalkTargetVelocity          Void (Float,Float,Float,Float)
     * DEPRECATED. Use moveToward() function instead.
     * x: Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
     * y: Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
     * theta: Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
     * frequency: Fraction of MaxStepFrequency [0.0 to 1.0]
     */
    public void setWalkTargetVelocity(Float param1, Float param2, Float param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", param1, param2, param3, param4);
        else
            service.call("setWalkTargetVelocity", param1, param2, param3, param4).get();
    }

    /**
     * 140 setWalkTargetVelocity          Void (Float,Float,Float,Float,Value)
     * DEPRECATED. Use moveToward() function instead.
     * x: Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
     * y: Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
     * theta: Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
     * frequency: Fraction of MaxStepFrequency [0.0 to 1.0]
     * feetGaitConfig: An ALValue with the custom gait configuration for both feet
     */
    public void setWalkTargetVelocity(Float param1, Float param2, Float param3, Float param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", param1, param2, param3, param4, param5);
        else
            service.call("setWalkTargetVelocity", param1, param2, param3, param4, param5).get();
    }

    /**
     * 141 setWalkTargetVelocity          Void (Float,Float,Float,Float,Value,Value)
     * DEPRECATED. Use moveToward() function instead.
     * x: Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
     * y: Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
     * theta: Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
     * frequency: Fraction of MaxStepFrequency [0.0 to 1.0]
     * leftFootMoveConfig: An ALValue with custom move configuration for the left foot
     * rightFootMoveConfig: An ALValue with custom move configuration for the right foot
     */
    public void setWalkTargetVelocity(Float param1, Float param2, Float param3, Float param4, com.aldebaran.qimessaging.Object param5, com.aldebaran.qimessaging.Object param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", param1, param2, param3, param4, param5, param6);
        else
            service.call("setWalkTargetVelocity", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 143 moveTo                         Void (Float,Float,Float)
     * Makes the robot move at the given position. This is a non-blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The position around z axis [rd].
     */
    public void moveTo(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3);
        else
            service.call("moveTo", param1, param2, param3).get();
    }

    /**
     * 144 moveTo                         Void (Float,Float,Float,Float)
     * Makes the robot move at the given position in fixed time. This is a non-blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The position around z axis [rd].
     * time: The time to reach the target position [s].
     */
    public void moveTo(Float param1, Float param2, Float param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3, param4);
        else
            service.call("moveTo", param1, param2, param3, param4).get();
    }

    /**
     * 145 moveTo                         Void (Float,Float,Float,Value)
     * Makes the robot move at the given position. This is a non-blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The position around z axis [rd].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveTo(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3, param4);
        else
            service.call("moveTo", param1, param2, param3, param4).get();
    }

    /**
     * 146 moveTo                         Void (Float,Float,Float,Float,Value)
     * Makes the robot move at the given position in fixed time. This is a non-blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The position around z axis [rd].
     * time: The time to reach the target position [s].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveTo(Float param1, Float param2, Float param3, Float param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3, param4, param5);
        else
            service.call("moveTo", param1, param2, param3, param4, param5).get();
    }

    /**
     * 147 moveTo                         Void (Value)
     * Makes the robot move to the given relative positions. This is a blocking call.
     * controlPoint: An ALValue with the control points in FRAME_ROBOT.
     * Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
     */
    public void moveTo(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1);
        else
            service.call("moveTo", param1).get();
    }

    /**
     * 148 moveTo                         Void (Value,Value)
     * Makes the robot move to the given relative positions. This is a blocking call.
     * controlPoint: An ALValue with all the control points in FRAME_ROBOT.
     * Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveTo(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2);
        else
            service.call("moveTo", param1, param2).get();
    }

    /**
     * 163 walkTo                         Void (Float,Float,Float)
     * DEPRECATED. Use moveTo() function instead.
     * x: Distance along the X axis in meters.
     * y: Distance along the Y axis in meters.
     * theta: Rotation around the Z axis in radians [-3.1415 to 3.1415].
     */
    public void walkTo(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("walkTo", param1, param2, param3);
        else
            service.call("walkTo", param1, param2, param3).get();
    }

    /**
     * 164 walkTo                         Void (Float,Float,Float,Value)
     * DEPRECATED. Use moveTo() function instead.
     * x: Distance along the X axis in meters.
     * y: Distance along the Y axis in meters.
     * theta: Rotation around the Z axis in radians [-3.1415 to 3.1415].
     * feetGaitConfig: An ALValue with the custom gait configuration for both feet.
     */
    public void walkTo(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("walkTo", param1, param2, param3, param4);
        else
            service.call("walkTo", param1, param2, param3, param4).get();
    }

    /**
     * 165 walkTo                         Void (Value)
     * DEPRECATED. Use moveTo() function instead.
     * controlPoint: An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
     */
    public void walkTo(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("walkTo", param1);
        else
            service.call("walkTo", param1).get();
    }

    /**
     * 166 walkTo                         Void (Value,Value)
     * DEPRECATED. Use moveTo() function instead.
     * controlPoint: An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
     * feetGaitConfig: An ALValue with the custom gait configuration for both feet
     */
    public void walkTo(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("walkTo", param1, param2);
        else
            service.call("walkTo", param1, param2).get();
    }

    /**
     * 167 setFootSteps                   Void (List<String>,Value,List<Float>,Bool)
     * Makes Nao do foot step planner. This is a non-blocking call.
     * legName: name of the leg to move('LLeg'or 'RLeg')
     * footSteps: [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
     * timeList: time list of each foot step
     * clearExisting: Clear existing foot steps.
     */
    public void setFootSteps(List<String> param1, com.aldebaran.qimessaging.Object param2, List<Float> param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFootSteps", param1, param2, param3, param4);
        else
            service.call("setFootSteps", param1, param2, param3, param4).get();
    }

    /**
     * 168 setFootStepsWithSpeed          Void (List<String>,Value,List<Float>,Bool)
     * Makes Nao do foot step planner with speed. This is a blocking call.
     * legName: name of the leg to move('LLeg'or 'RLeg')
     * footSteps: [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
     * fractionMaxSpeed: speed of each foot step. Must be between 0 and 1.
     * clearExisting: Clear existing foot steps.
     */
    public void setFootStepsWithSpeed(List<String> param1, com.aldebaran.qimessaging.Object param2, List<Float> param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFootStepsWithSpeed", param1, param2, param3, param4);
        else
            service.call("setFootStepsWithSpeed", param1, param2, param3, param4).get();
    }

    /**
     * 169 getFootSteps                   Value ()
     * Get the foot steps. This is a non-blocking call.
     * return: Give two list of foot steps. The first one give the unchangeable foot step. The second list give the changeable foot steps. Il you use setFootSteps or setFootStepsWithSpeed with clearExisting parmater equal true, walk engine execute unchangeable foot step and remove the other.
     */
    public com.aldebaran.qimessaging.Object getFootSteps() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFootSteps").get();
    }

    /**
     * 170 walkInit                       Void ()
     * DEPRECATED. Use moveInit function instead.
     */
    public void walkInit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("walkInit");
        else
            service.call("walkInit").get();
    }

    /**
     * 171 moveInit                       Void ()
     * Initialize the move process. Check the robot pose and take a right posture. This is blocking called.
     */
    public void moveInit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveInit");
        else
            service.call("moveInit").get();
    }

    /**
     * 172 waitUntilWalkIsFinished        Void ()
     * DEPRECATED. Use waitUntilMoveIsFinished function instead.
     */
    public void waitUntilWalkIsFinished() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("waitUntilWalkIsFinished");
        else
            service.call("waitUntilWalkIsFinished").get();
    }

    /**
     * 173 waitUntilMoveIsFinished        Void ()
     * Waits until the move process is finished: This method can be used to block your script/code execution until the move task is totally finished.
     */
    public void waitUntilMoveIsFinished() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("waitUntilMoveIsFinished");
        else
            service.call("waitUntilMoveIsFinished").get();
    }

    /**
     * 174 walkIsActive                   Bool ()
     * DEPRECATED. Use moveIsActive function instead.
     */
    public Boolean walkIsActive() throws CallError, InterruptedException {
        return (Boolean) service.call("walkIsActive").get();
    }

    /**
     * 175 moveIsActive                   Bool ()
     * Check if the move process is actif.
     * return: True if move is active
     */
    public Boolean moveIsActive() throws CallError, InterruptedException {
        return (Boolean) service.call("moveIsActive").get();
    }

    /**
     * 176 stopWalk                       Void ()
     * DEPRECATED. Use stopMove function instead.
     */
    public void stopWalk() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopWalk");
        else
            service.call("stopWalk").get();
    }

    /**
     * 177 stopMove                       Void ()
     * Stop Move task safely as fast as possible. The move task is ended less brutally than killMove but more quickly than move(0.0, 0.0, 0.0).
     * This is a blocking call.
     */
    public void stopMove() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopMove");
        else
            service.call("stopMove").get();
    }

    /**
     * 178 getFootGaitConfig              Value (String)
     * DEPRECATED. Use getMoveConfig function instead.
     * Gets the foot Gait config ("MaxStepX", "MaxStepY", "MaxStepTheta",  "MaxStepFrequency", "StepHeight", "TorsoWx", "TorsoWy")
     * config: a string should be "Max", "Min", "Default"
     * return: An ALvalue with the following form :[["MaxStepX", value],
     * ["MaxStepY", value],
     * ["MaxStepTheta", value],
     * ["MaxStepFrequency", value],
     * ["StepHeight", value],
     * ["TorsoWx", value],
     * ["TorsoWy", value]]
     */
    public com.aldebaran.qimessaging.Object getFootGaitConfig(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFootGaitConfig", param1).get();
    }

    /**
     * 179 getMoveConfig                  Value (String)
     * Gets the move config.
     * config: a string should be "Max", "Min", "Default"
     * return: An ALvalue with the move config
     */
    public com.aldebaran.qimessaging.Object getMoveConfig(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMoveConfig", param1).get();
    }

    /**
     * 180 getRobotPosition               List<Float> (Bool)
     * Gets the World Absolute Robot Position.
     * useSensors: If true, use the sensor values
     * return: A vector containing the World Absolute Robot Position. (Absolute Position X, Absolute Position Y, Absolute Angle Z)
     */
    public List<Float> getRobotPosition(Boolean param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getRobotPosition", param1).get();
    }

    /**
     * 181 getNextRobotPosition           List<Float> ()
     * Gets the World Absolute next Robot Position.
     * In fact in the walk algorithm some foot futur foot step are incompressible due to preview control, so this function give the next robot position which is incompressible.
     * If the robot doesn't walk this function is equivalent to getRobotPosition(false)
     * return: A vector containing the World Absolute next Robot position.(Absolute Position X, Absolute Position Y, Absolute Angle Z)
     */
    public List<Float> getNextRobotPosition() throws CallError, InterruptedException {
        return (List<Float>) service.call("getNextRobotPosition").get();
    }

    /**
     * 183 getRobotVelocity               List<Float> ()
     * Gets the World Absolute Robot Velocity.
     * return: A vector containing the World Absolute Robot Velocity. (Absolute Velocity Translation X [m.s-1], Absolute Velocity Translation Y[m.s-1], Absolute Velocity Rotation WZ [rd.s-1])
     */
    public List<Float> getRobotVelocity() throws CallError, InterruptedException {
        return (List<Float>) service.call("getRobotVelocity").get();
    }

    /**
     * 185 getWalkArmsEnabled             Value ()
     * DEPRECATED. Gets if Arms Motions are enabled during the Walk Process.
     * return: True Arm Motions are controlled by the Walk Task.
     */
    public com.aldebaran.qimessaging.Object getWalkArmsEnabled() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getWalkArmsEnabled").get();
    }

    /**
     * 186 setWalkArmsEnabled             Void (Bool,Bool)
     * DEPRECATED. Sets if Arms Motions are enabled during the Walk Process.
     * leftArmEnabled: if true Left Arm motions are controlled by the Walk Task
     * rightArmEnabled: if true Right Arm mMotions are controlled by the Walk Task
     */
    public void setWalkArmsEnabled(Boolean param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setWalkArmsEnabled", param1, param2);
        else
            service.call("setWalkArmsEnabled", param1, param2).get();
    }

    /**
     * 187 getMoveArmsEnabled             Bool (String)
     * Gets if Arms Motions are enabled during the Move Process.
     * chainName: Name of the chain. Could be: "LArm", "RArm" or "Arms"
     * return: For LArm and RArm true if the corresponding arm is enabled. For Arms, true if both are enabled. False otherwise.
     */
    public Boolean getMoveArmsEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getMoveArmsEnabled", param1).get();
    }

    /**
     * 188 setMoveArmsEnabled             Void (Bool,Bool)
     * Sets if Arms Motions are enabled during the Move Process.
     * leftArmEnabled: if true Left Arm motions are controlled by the Move Task
     * rightArmEnabled: if true Right Arm mMotions are controlled by the Move Task
     */
    public void setMoveArmsEnabled(Boolean param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMoveArmsEnabled", param1, param2);
        else
            service.call("setMoveArmsEnabled", param1, param2).get();
    }

    /**
     * 189 positionInterpolation          Void (String,Int32,Value,Int32,Value,Bool)
     * DEPRECATED. Use positionInterpolations function instead.
     * chainName: Name of the chain. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso"
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * path: Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * durations: Vector of times in seconds corresponding to the path points
     * isAbsolute: If true, the movement is absolute else relative
     */
    public void positionInterpolation(String param1, Integer param2, com.aldebaran.qimessaging.Object param3, Integer param4, com.aldebaran.qimessaging.Object param5, Boolean param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("positionInterpolation", param1, param2, param3, param4, param5, param6);
        else
            service.call("positionInterpolation", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 190 positionInterpolations         Void (List<String>,Int32,Value,Value,Value,Bool)
     * DEPRECATED. Use the other positionInterpolations function instead.
     * effectorNames: Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso"
     * taskSpaceForAllPaths: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * paths: Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
     * axisMasks: Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * relativeTimes: Vector of times in seconds corresponding to the path points
     * isAbsolute: If true, the movement is absolute else relative
     */
    public void positionInterpolations(List<String> param1, Integer param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4, com.aldebaran.qimessaging.Object param5, Boolean param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("positionInterpolations", param1, param2, param3, param4, param5, param6);
        else
            service.call("positionInterpolations", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 191 positionInterpolations         Void (Value,Value,Value,Value,Value)
     * Moves end-effectors to the given positions and orientations over time. This is a blocking call.
     * effectorNames: Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso"
     * taskSpaceForAllPaths: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * paths: Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
     * axisMasks: Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * relativeTimes: Vector of times in seconds corresponding to the path points
     */
    public void positionInterpolations(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("positionInterpolations", param1, param2, param3, param4, param5);
        else
            service.call("positionInterpolations", param1, param2, param3, param4, param5).get();
    }

    /**
     * 192 setPosition                    Void (String,Int32,List<Float>,Float,Int32)
     * Moves an end-effector to DEPRECATED. Use setPositions function instead.
     * chainName: Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * position: 6D position array (x,y,z,wx,wy,wz) in meters and radians
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void setPosition(String param1, Integer param2, List<Float> param3, Float param4, Integer param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPosition", param1, param2, param3, param4, param5);
        else
            service.call("setPosition", param1, param2, param3, param4, param5).get();
    }

    /**
     * 193 setPositions                   Void (Value,Value,Value,Float,Value)
     * Moves multiple end-effectors to the given position and orientation position6d. This is a non-blocking call.
     * names: The name or names of effector.
     * spaces: The task frame or task frames {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * positions: Position6D arrays
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void setPositions(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, Float param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPositions", param1, param2, param3, param4, param5);
        else
            service.call("setPositions", param1, param2, param3, param4, param5).get();
    }

    /**
     * 194 changePosition                 Void (String,Int32,List<Float>,Float,Int32)
     * DEPRECATED. Use setPositions function instead.
     * effectorName: Name of the effector.
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * positionChange: 6D position change array (xd, yd, zd, wxd, wyd, wzd) in meters and radians
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void changePosition(String param1, Integer param2, List<Float> param3, Float param4, Integer param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("changePosition", param1, param2, param3, param4, param5);
        else
            service.call("changePosition", param1, param2, param3, param4, param5).get();
    }

    /**
     * 195 getPosition                    List<Float> (String,Int32,Bool)
     * Gets a Position relative to the FRAME. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical. The angle convention of Position6D is Rot_z(wz).Rot_y(wy).Rot_x(wx).
     * name: Name of the item. Could be: Head, LArm, RArm, LLeg, RLeg, Torso, CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot.
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * useSensorValues: If true, the sensor values will be used to determine the position.
     * return: Vector containing the Position6D using meters and radians (x, y, z, wx, wy, wz)
     */
    public List<Float> getPosition(String param1, Integer param2, Boolean param3) throws CallError, InterruptedException {
        return (List<Float>) service.call("getPosition", param1, param2, param3).get();
    }

    /**
     * 196 transformInterpolation         Void (String,Int32,Value,Int32,Value,Bool)
     * DEPRECATED. Use the other transformInterpolations function instead.
     * chainName: Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * path: Vector of Transform arrays
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * duration: Vector of times in seconds corresponding to the path points
     * isAbsolute: If true, the movement is absolute else relative
     */
    public void transformInterpolation(String param1, Integer param2, com.aldebaran.qimessaging.Object param3, Integer param4, com.aldebaran.qimessaging.Object param5, Boolean param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("transformInterpolation", param1, param2, param3, param4, param5, param6);
        else
            service.call("transformInterpolation", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 197 transformInterpolations        Void (List<String>,Int32,Value,Value,Value,Bool)
     * DEPRECATED. Use the other transformInterpolations function instead.
     * effectorNames: Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso"
     * taskSpaceForAllPaths: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * paths: Vector of transforms arrays.
     * axisMasks: Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * relativeTimes: Vector of times in seconds corresponding to the path points
     * isAbsolute: If true, the movement is absolute else relative
     */
    public void transformInterpolations(List<String> param1, Integer param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4, com.aldebaran.qimessaging.Object param5, Boolean param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("transformInterpolations", param1, param2, param3, param4, param5, param6);
        else
            service.call("transformInterpolations", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 198 transformInterpolations        Void (Value,Value,Value,Value,Value)
     * Moves end-effectors to the given positions and orientations over time. This is a blocking call.
     * effectorNames: Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso"
     * taskSpaceForAllPaths: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * paths: Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
     * axisMasks: Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     * relativeTimes: Vector of times in seconds corresponding to the path points
     */
    public void transformInterpolations(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("transformInterpolations", param1, param2, param3, param4, param5);
        else
            service.call("transformInterpolations", param1, param2, param3, param4, param5).get();
    }

    /**
     * 199 setTransform                   Void (String,Int32,List<Float>,Float,Int32)
     * Moves an end-effector to DEPRECATED. Use setTransforms function instead.
     * chainName: Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * transform: Transform arrays
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void setTransform(String param1, Integer param2, List<Float> param3, Float param4, Integer param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTransform", param1, param2, param3, param4, param5);
        else
            service.call("setTransform", param1, param2, param3, param4, param5).get();
    }

    /**
     * 200 setTransforms                  Void (Value,Value,Value,Float,Value)
     * Moves multiple end-effectors to the given position and orientation transforms. This is a non-blocking call.
     * names: The name or names of effector.
     * spaces: The task frame or task frames {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * transforms: Transform arrays
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void setTransforms(com.aldebaran.qimessaging.Object param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, Float param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTransforms", param1, param2, param3, param4, param5);
        else
            service.call("setTransforms", param1, param2, param3, param4, param5).get();
    }

    /**
     * 201 changeTransform                Void (String,Int32,List<Float>,Float,Int32)
     * DEPRECATED. Use setTransforms function instead.
     * chainName: Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * transform: Transform arrays
     * fractionMaxSpeed: The fraction of maximum speed to use
     * axisMask: Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both
     */
    public void changeTransform(String param1, Integer param2, List<Float> param3, Float param4, Integer param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("changeTransform", param1, param2, param3, param4, param5);
        else
            service.call("changeTransform", param1, param2, param3, param4, param5).get();
    }

    /**
     * 202 getTransform                   List<Float> (String,Int32,Bool)
     * Gets an Homogenous Transform relative to the FRAME. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical.
     * name: Name of the item. Could be: any joint or chain or sensor (Head, LArm, RArm, LLeg, RLeg, Torso, HeadYaw, ..., CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot.
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * useSensorValues: If true, the sensor values will be used to determine the position.
     * return: Vector of 16 floats corresponding to the values of the matrix, line by line.
     */
    public List<Float> getTransform(String param1, Integer param2, Boolean param3) throws CallError, InterruptedException {
        return (List<Float>) service.call("getTransform", param1, param2, param3).get();
    }

    /**
     * 204 wbEnable                       Void (Bool)
     * UserFriendly Whole Body API: enable Whole Body Balancer. It's a Generalized Inverse Kinematics which deals with cartesian control, balance, redundancy and task priority. The main goal is to generate and stabilized consistent motions without precomputed trajectories and adapt nao's behaviour to the situation. The generalized inverse kinematic problem takes in account equality constraints (keep foot fix), inequality constraints (joint limits, balance, ...) and quadratic minimization (cartesian / articular desired trajectories). We solve each step a quadratic programming on the robot.
     * isEnabled: Active / Disactive Whole Body Balancer.
     */
    public void wbEnable(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbEnable", param1);
        else
            service.call("wbEnable", param1).get();
    }

    /**
     * 205 wbFootState                    Void (String,String)
     * UserFriendly Whole Body API: set the foot state: fixed foot, constrained in a plane or free.
     * stateName: Name of the foot state. "Fixed" set the foot fixed. "Plane" constrained the Foot in the plane. "Free" set the foot free.
     * supportLeg: Name of the foot. "LLeg", "RLeg" or "Legs".
     */
    public void wbFootState(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbFootState", param1, param2);
        else
            service.call("wbFootState", param1, param2).get();
    }

    /**
     * 206 wbEnableBalanceConstraint      Void (Bool,String)
     * UserFriendly Whole Body API: enable to keep balance in support polygon.
     * isEnable: Enable Nao to keep balance.
     * supportLeg: Name of the support leg: "Legs", "LLeg", "RLeg".
     */
    public void wbEnableBalanceConstraint(Boolean param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbEnableBalanceConstraint", param1, param2);
        else
            service.call("wbEnableBalanceConstraint", param1, param2).get();
    }

    /**
     * 207 wbGoToBalance                  Void (String,Float)
     * Advanced Whole Body API: "Com" go to a desired support polygon. This is a blocking call.
     * supportLeg: Name of the support leg: "Legs", "LLeg", "RLeg".
     * duration: Time in seconds. Must be upper 0.5 s.
     */
    public void wbGoToBalance(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbGoToBalance", param1, param2);
        else
            service.call("wbGoToBalance", param1, param2).get();
    }

    /**
     * 208 wbEnableEffectorControl        Void (String,Bool)
     * UserFriendly Whole Body API: enable whole body cartesian control of an effector.
     * effectorName: Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
     * isEnabled: Active / Disactive Effector Control.
     */
    public void wbEnableEffectorControl(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbEnableEffectorControl", param1, param2);
        else
            service.call("wbEnableEffectorControl", param1, param2).get();
    }

    /**
     * 209 wbSetEffectorControl           Void (String,Value)
     * UserFriendly Whole Body API: set new target for controlled effector. This is a non-blocking call.
     * effectorName: Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
     * targetCoordinate: "Head" is controlled in rotation (WX, WY, WZ). "LArm" and "RArm" are controlled in position (X, Y, Z). TargetCoordinate must be absolute and expressed in FRAME_ROBOT. If the desired position/orientation is unfeasible, target is resize to the nearest feasible motion.
     */
    public void wbSetEffectorControl(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbSetEffectorControl", param1, param2);
        else
            service.call("wbSetEffectorControl", param1, param2).get();
    }

    /**
     * 210 wbEnableEffectorOptimization   Void (String,Bool)
     * Advanced Whole Body API: enable to control an effector as an optimization.
     * effectorName: Name of the effector : "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
     * isActive: if true, the effector control is taken in acount in the optimization criteria.
     */
    public void wbEnableEffectorOptimization(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wbEnableEffectorOptimization", param1, param2);
        else
            service.call("wbEnableEffectorOptimization", param1, param2).get();
    }

    /**
     * 227 setCollisionProtectionEnabled  Bool (String,Bool)
     * Enable Anticollision protection of the arms of the robot. Use api isCollision to know if a chain is in collision and can be disactivated.
     * pChainName: The chain name {"Arms", "LArm" or "RArm"}.
     * pEnable: Activate or disactivate the anticollision of the desired Chain.
     * return: A bool which return always true.
     */
    public Boolean setCollisionProtectionEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setCollisionProtectionEnabled", param1, param2).get();
    }

    /**
     * 228 getCollisionProtectionEnabled  Bool (String)
     * Allow to know if the collision protection is activated on the given chain.
     * pChainName: The chain name {"LArm" or "RArm"}.
     * return: Return true is the collision protection of the given Arm is activated.
     */
    public Boolean getCollisionProtectionEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getCollisionProtectionEnabled", param1).get();
    }

    /**
     * 229 setExternalCollisionProtectionEnabled Void (String,Bool)
     * Enable Anticollision protection of the arms and base move  of the robot with external environment.
     * pName: The name {"All", "Move", "Arms", "LArm" or "RArm"}.
     * pEnable: Activate or disactivate the anticollision of the desired name.
     */
    public void setExternalCollisionProtectionEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setExternalCollisionProtectionEnabled", param1, param2);
        else
            service.call("setExternalCollisionProtectionEnabled", param1, param2).get();
    }

    /**
     * 231 getChainClosestObstaclePosition List<Float> (String,Int32)
     * Gets chain closest obstacle Position .
     * pName: The Chain name {"LArm" or "RArm"}.
     * space: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * return: Vector containing the Position3D in meters (x, y, z)
     */
    public List<Float> getChainClosestObstaclePosition(String param1, Integer param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getChainClosestObstaclePosition", param1, param2).get();
    }

    /**
     * 232 getExternalCollisionProtectionEnabled Bool (String)
     * Allow to know if the external collision protection is activated on the given name.
     * pName: The name {"All", "Move", "Arms", "LArm" or "RArm"}.
     * return: Return true is the external collision protection of the given name is activated.
     */
    public Boolean getExternalCollisionProtectionEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getExternalCollisionProtectionEnabled", param1).get();
    }

    /**
     * 233 setOrthogonalSecurityDistance  Void (Float)
     * Defines the orthogonal security distance used with external collision protection "Move".
     * securityDistance: The orthogonal security distance.
     */
    public void setOrthogonalSecurityDistance(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setOrthogonalSecurityDistance", param1);
        else
            service.call("setOrthogonalSecurityDistance", param1).get();
    }

    /**
     * 234 getOrthogonalSecurityDistance  Float ()
     * Gets the current orthogonal security distance.
     * return: The current orthogonal security distance.
     */
    public Float getOrthogonalSecurityDistance() throws CallError, InterruptedException {
        return (Float) service.call("getOrthogonalSecurityDistance").get();
    }

    /**
     * 235 setTangentialSecurityDistance  Void (Float)
     * Defines the tangential security distance used with external collision protection "Move".
     * securityDistance: The tangential security distance.
     */
    public void setTangentialSecurityDistance(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTangentialSecurityDistance", param1);
        else
            service.call("setTangentialSecurityDistance", param1).get();
    }

    /**
     * 236 getTangentialSecurityDistance  Float ()
     * Gets the current tangential security distance.
     * return: The current tangential security distance.
     */
    public Float getTangentialSecurityDistance() throws CallError, InterruptedException {
        return (Float) service.call("getTangentialSecurityDistance").get();
    }

    /**
     * 237 isCollision                    String (String)
     * Give the collision state of a chain. If a chain has a collision state "none" or "near", it could be desactivated.
     * pChainName: The chain name {"Arms", "LArm" or "RArm"}.
     * return: A string which notice the collision state: "none" there are no collision, "near" the collision is taking in account in the anti-collision algorithm, "collision" the chain is in contact with an other body. If the chain asked is "Arms" the most unfavorable result is given.
     */
    public String isCollision(String param1) throws CallError, InterruptedException {
        return (String) service.call("isCollision", param1).get();
    }

    /**
     * 245 setFallManagerEnabled          Void (Bool)
     * Enable The fall manager protection for the robot. When a fall is detected the robot adopt a joint configuration to protect himself and cut the stiffness.
     * . An memory event called "robotHasFallen" is generated when the fallManager have been activated.
     * pEnable: Activate or disactivate the smart stiffness.
     */
    public void setFallManagerEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFallManagerEnabled", param1);
        else
            service.call("setFallManagerEnabled", param1).get();
    }

    /**
     * 246 getFallManagerEnabled          Bool ()
     * Give the state of the fall manager.
     * return: Return true is the fall manager is activated.
     */
    public Boolean getFallManagerEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("getFallManagerEnabled").get();
    }

    /**
     * 247 setPushRecoveryEnabled         Void (Bool)
     * Enable The push recovery protection for the robot.
     * pEnable: Enable the push recovery.
     */
    public void setPushRecoveryEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPushRecoveryEnabled", param1);
        else
            service.call("setPushRecoveryEnabled", param1).get();
    }

    /**
     * 249 getPushRecoveryEnabled         Bool ()
     * Give the state of the push recovery.
     * return: Return true is the push recovery is activated.
     */
    public Boolean getPushRecoveryEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("getPushRecoveryEnabled").get();
    }

    /**
     * 250 setSmartStiffnessEnabled       Void (Bool)
     * Enable Smart Stiffness for all the joints (True by default), the update take one motion cycle for updating. The smart Stiffness is a gestion of joint maximum torque. More description is available on the red documentation of ALMotion module.
     * pEnable: Activate or disactivate the smart stiffness.
     */
    public void setSmartStiffnessEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setSmartStiffnessEnabled", param1);
        else
            service.call("setSmartStiffnessEnabled", param1).get();
    }

    /**
     * 251 getSmartStiffnessEnabled       Bool ()
     * Give the state of the smart Stiffness.
     * return: Return true is the smart Stiffnes is activated.
     */
    public Boolean getSmartStiffnessEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("getSmartStiffnessEnabled").get();
    }

    /**
     * 252 setDiagnosisEffectEnabled      Void (Bool)
     * Enable or disable the diagnosis effect into ALMotion
     * pEnable: Enable or disable the diagnosis effect.
     */
    public void setDiagnosisEffectEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDiagnosisEffectEnabled", param1);
        else
            service.call("setDiagnosisEffectEnabled", param1).get();
    }

    /**
     * 253 getDiagnosisEffectEnabled      Bool ()
     * Give the state of the diagnosis effect.
     * return: Return true is the diagnosis reflex is activated.
     */
    public Boolean getDiagnosisEffectEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("getDiagnosisEffectEnabled").get();
    }

    /**
     * 254 getJointNames                  List<String> (String)
     * DEPRECATED. Use getBodyNames function instead.
     * name: Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
     * return: Vector of strings, one for each joint in the collection
     */
    public List<String> getJointNames(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getJointNames", param1).get();
    }

    /**
     * 255 getBodyNames                   List<String> (String)
     * Gets the names of all the joints and actuators in the collection.
     * name: Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
     * return: Vector of strings, one for each joint and actuator in the collection
     */
    public List<String> getBodyNames(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getBodyNames", param1).get();
    }

    /**
     * 256 getSensorNames                 List<String> ()
     * Gets the list of sensors supported on your robot.
     * return: Vector of sensor names
     */
    public List<String> getSensorNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getSensorNames").get();
    }

    /**
     * 257 getLimits                      Value (String)
     * Get the minAngle (rad), maxAngle (rad), and maxVelocity (rad.s-1) for a given joint or actuator in the body.
     * name: Name of a joint, chain, "Body", "JointActuators", "Joints" or "Actuators".
     * return: Array of ALValue arrays containing the minAngle, maxAngle, maxVelocity and maxTorque for all the bodies specified.
     */
    public com.aldebaran.qimessaging.Object getLimits(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getLimits", param1).get();
    }

    /**
     * 259 getMotionCycleTime             Int32 ()
     * Get the motion cycle time in milliseconds.
     * return: Expressed in milliseconds
     */
    public Integer getMotionCycleTime() throws CallError, InterruptedException {
        return (Integer) service.call("getMotionCycleTime").get();
    }

    /**
     * 261 getRobotConfig                 Value ()
     * Get the robot configuration.
     * return: ALValue arrays containing the robot parameter names and the robot parameter values.
     */
    public com.aldebaran.qimessaging.Object getRobotConfig() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getRobotConfig").get();
    }

    /**
     * 262 getSummary                     String ()
     * Returns a string representation of the Model's state
     * return: A formated string
     */
    public String getSummary() throws CallError, InterruptedException {
        return (String) service.call("getSummary").get();
    }

    /**
     * 263 getMass                        Float (String)
     * Gets the mass of a joint, chain, "Body" or "Joints".
     * pName: Name of the body which we want the mass. "Body", "Joints" and "Com" give the total mass of nao. For the chain, it gives the total mass of the chain.
     * return: The mass in kg.
     */
    public Float getMass(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMass", param1).get();
    }

    /**
     * 264 getCOM                         List<Float> (String,Int32,Bool)
     * Gets the COM of a joint, chain, "Body" or "Joints".
     * pName: Name of the body which we want the mass. In chain name case, this function give the com of the chain.
     * pSpace: Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * pUseSensorValues: If true, the sensor values will be used to determine the position.
     * return: The COM position (meter).
     */
    public List<Float> getCOM(String param1, Integer param2, Boolean param3) throws CallError, InterruptedException {
        return (List<Float>) service.call("getCOM", param1, param2, param3).get();
    }

    /**
     * 267 setMotionConfig                Void (Value)
     * Internal Use.
     * config: Internal: An array of ALValues [i][0]: name, [i][1]: value
     */
    public void setMotionConfig(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMotionConfig", param1);
        else
            service.call("setMotionConfig", param1).get();
    }

    /**
     * 270 updateTrackerTarget            Void (Float,Float,Int32,Bool)
     * Update the target to follow by the head of NAO.
     * DEPRECATED Function. Please use ALTracker::lookAt.
     * pTargetPositionWy: The target position wy in FRAME_ROBOT
     * pTargetPositionWz: The target position wz in  FRAME_ROBOT
     * pTimeSinceDetectionMs: The time in Ms since the target was detected
     * pUseOfWholeBody: If true, the target is follow in cartesian space by the Head with whole Body constraints.
     */
    public void updateTrackerTarget(Float param1, Float param2, Integer param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updateTrackerTarget", param1, param2, param3, param4);
        else
            service.call("updateTrackerTarget", param1, param2, param3, param4).get();
    }

    /**
     * 277 setBreathEnabled               Void (String,Bool)
     * This function starts or stops breathing animation on a chain.
     * Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
     * Head breathing animation will work only if Leg animation is active.
     * pChain: Chain name.
     * pIsEnabled: Enables / disables the chain.
     */
    public void setBreathEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBreathEnabled", param1, param2);
        else
            service.call("setBreathEnabled", param1, param2).get();
    }

    /**
     * 278 getBreathEnabled               Bool (String)
     * This function gets the status of breathing animation on a chain.
     * Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
     * pChain: Chain name.
     * return: True if breathing animation is enabled on the chain.
     */
    public Boolean getBreathEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getBreathEnabled", param1).get();
    }

    /**
     * 279 setBreathConfig                Void (Value)
     * This function configures the breathing animation.
     * pConfig: Breath configuration.
     * An ALValue of the form [["Bpm", pBpm], ["Amplitude", pAmplitude]].
     * pBpm is a float between 10 and 50 setting the breathing frequency in beats per minute.
     * pAmplitude is a float between 0 and 1 setting the amplitude of the breathing animation.
     */
    public void setBreathConfig(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBreathConfig", param1);
        else
            service.call("setBreathConfig", param1).get();
    }

    /**
     * 280 getBreathConfig                Value ()
     * This function gets the current breathing configuration.
     * return: An ALValue of the form [["Bpm", bpm], ["Amplitude", amplitude]].
     * bpm is the breathing frequency in beats per minute.
     * amplitude is the normalized amplitude of the breathing animation, between 0 and 1.
     */
    public com.aldebaran.qimessaging.Object getBreathConfig() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getBreathConfig").get();
    }

    /**
     * 281 setIdlePostureEnabled          Void (String,Bool)
     * Starts or stops idle posture management on a chain.
     * Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
     * pChain: Chain name.
     * pIsEnabled: Enables / disables the chain.
     */
    public void setIdlePostureEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setIdlePostureEnabled", param1, param2);
        else
            service.call("setIdlePostureEnabled", param1, param2).get();
    }

    /**
     * 282 getIdlePostureEnabled          Bool (String)
     * This function gets the status of idle posture management on a chain.
     * Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
     * pChain: Chain name.
     * return: True if breathing animation is enabled on the chain.
     */
    public Boolean getIdlePostureEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getIdlePostureEnabled", param1).get();
    }

    /**
     * 284 getTaskList                    Value ()
     * Gets an ALValue structure describing the tasks in the Task List
     * return: An ALValue containing an ALValue for each task. The inner ALValue contains: Name, MotionID
     */
    public com.aldebaran.qimessaging.Object getTaskList() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getTaskList").get();
    }

    /**
     * 285 areResourcesAvailable          Bool (List<String>)
     * Returns true if all the desired resources are available. Only motion API's' blocking call takes resources.
     * resourceNames: A vector of resource names such as joints. Use getBodyNames("Body") to have the list of the available joint for your robot.
     * return: True if the resources are available
     */
    public Boolean areResourcesAvailable(List<String> param1) throws CallError, InterruptedException {
        return (Boolean) service.call("areResourcesAvailable", param1).get();
    }

    /**
     * 286 killTask                       Bool (Int32)
     * Kills a motion task.
     * motionTaskID: TaskID of the motion task you want to kill.
     * return: Return true if the specified motionTaskId has been killed.
     */
    public Boolean killTask(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("killTask", param1).get();
    }

    /**
     * 287 killTasksUsingResources        Void (List<String>)
     * Kills all tasks that use any of the resources given. Only motion API's' blocking call takes resources and can be killed. Use getBodyNames("Body") to have the list of the available joint for your robot.
     * resourceNames: A vector of resource joint names
     */
    public void killTasksUsingResources(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("killTasksUsingResources", param1);
        else
            service.call("killTasksUsingResources", param1).get();
    }

    /**
     * 288 killWalk                       Void ()
     * DEPRECATED. Use killMove function instead.
     */
    public void killWalk() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("killWalk");
        else
            service.call("killWalk").get();
    }

    /**
     * 289 killMove                       Void ()
     * Emergency Stop on Move task: This method will end the move task brutally, without attempting to return to a balanced state. The robot could easily fall.
     */
    public void killMove() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("killMove");
        else
            service.call("killMove").get();
    }

    /**
     * 290 killAll                        Void ()
     * Kills all tasks.
     */
    public void killAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("killAll");
        else
            service.call("killAll").get();
    }

    /**
     * 291 setEnableNotifications         Void (Bool)
     * Enable / Disable notifications.
     * enable: If True enable notifications. If False disable notifications.
     */
    public void setEnableNotifications(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setEnableNotifications", param1);
        else
            service.call("setEnableNotifications", param1).get();
    }

    /**
     * 292 areNotificationsEnabled        Bool ()
     * Return true if notifications are active.
     * return: Return True if notifications are active.
     * * Signals:
     */
    public Boolean areNotificationsEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("areNotificationsEnabled").get();
    }


}
    