package fr.ghostwan.waoremote;

import fr.ghostwan.waoremote.qihelper.ProxyHelper;

/**
 * Created by erwan on 26/04/2014.
 */
public class QiCommand {

    public static final int TYPE_COMMAND = 0;
    public static final int TYPE_DIALOG = 1;
    public static final int TYPE_BEHAVIOR = 2;
    public static final int TYPE_POSTURE = 3;
    private String name;
    private String proxy;
    private String command;
    private Object[] arguments;

    private int type = TYPE_COMMAND;


    public static QiCommand newQiDialog(String name, String sentence) {
        return new QiCommand(TYPE_DIALOG,name, "ALTextToSpeech", "say", sentence);
    }
    public static QiCommand newQiBehavior(String name, String behavior) {
        return new QiCommand(TYPE_BEHAVIOR,name, "ALBehaviorManager", "runBehavior", behavior);
    }

    public static QiCommand newQiPosture(String posture, Double speed) {
        return new QiCommand(TYPE_POSTURE, posture, "ALRobotPosture", "goToPosture", posture, speed);
    }

    public QiCommand(int type, String name , String proxy, String command, Object... arguments) {
        this.type = type;
        this.name = name;
        this.proxy = proxy;
        this.command = command;
        this.arguments = arguments;
    }

    public QiCommand(String name , String proxy, String command, Object... arguments) {
        this.name = name;
        this.proxy = proxy;
        this.command = command;
        this.arguments = arguments;
    }

    public void launch() throws ProxyHelper.ProxyException {
        ProxyHelper.call(proxy, command, arguments);
    }


    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public int getType() {
        return type;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArgumentString() {
        String result = "";
        for (Object argument : arguments) {
            result += argument.toString()+"  ";
        }
        return result;
    }
}
