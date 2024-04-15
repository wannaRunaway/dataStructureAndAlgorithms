package commandpattern;

/*
 * 命令模式；
 * 支持遥控器的命令模式
 * 命令模式将发出请求的对象和执行的对象解耦。A调用命令对象execute(), b接收的动作被调用
 * s*/
public class CommandRemote {
    public interface Command {
        public void execute();
        /* 撤销 */
        public void undo();
    }

    static class NoCommand implements Command {
        @Override
        public void execute() {
        }

        @Override
        public void undo() {

        }
    }

    /* 7个遥控器开关的命令 */
    static class RemoteControl {
        Command[] offCommands;
        Command[] onCommands;
        Command undoCommand;
        Command noCommand = new NoCommand();

        public RemoteControl() {
            onCommands = new Command[7];
            offCommands = new Command[7];
            for (int i = 0; i < 7; i++) {
                onCommands[i] = noCommand;
                offCommands[i] = noCommand;
            }
            undoCommand = noCommand;
        }

        public void setCommand(int slot, Command onCommand, Command offCommand) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }

        public void onButtonWasPushed(int slot) {
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        }

        public void offButtonWasPush(int slot) {
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        }

        /* 撤销功能 */
        public void undoButtonWasPushed() {
            undoCommand.undo();
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\n ---- Remote Control --------\n");
            for (int i = 0; i < onCommands.length; i++) {
                stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                        + "   " + offCommands[i].getClass().getName() + "\n");
            }
            return stringBuffer.toString();
        }
    }

    /*
     * 遥控器开灯
     * */
    public static class LightOnCommand implements Command {
        Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
        }

        @Override
        public void undo() {
            light.off();
        }
    }

    /*
     * 灯，开关2中状态
     * */
    static class Light {
        public Light(String message) {
            System.out.println("first init " + message);
        }

        void on() {
            System.out.println("Light is on()");
        }

        void off() {
            System.out.println("Light is off()");
        }
    }

    /*
     * 音响，多种状态
     * */
    static class Stereo {
        void on() {
            System.out.println("Stereo is On()");
        }

        void off() {
            System.out.println("stereo is off()");
        }

        void setCD() {
            System.out.println("stereo is serCD()");
        }

        void setVolume(int volume) {
            System.out.println("stereo volume is " + volume);
        }
    }

    /*
     * 关闭灯的命令
     * */
    static class LightOffCommand implements Command {
        Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.off();
        }

        @Override
        public void undo() {
            light.on();
        }
    }

    /*
     * 开启音响
     * */
    static class StereoOnWithCDCommand implements Command {
        Stereo stereo;

        public StereoOnWithCDCommand(Stereo stereo) {
            this.stereo = stereo;
        }

        @Override
        public void execute() {
            stereo.on();
            stereo.setCD();
            stereo.setVolume(11);
        }

        @Override
        public void undo() {

        }
    }

    /*
     * 关闭音响
     * */
    static class StereoOffWithCDCommand implements Command {
        Stereo stereo;

        public StereoOffWithCDCommand(Stereo stereo) {
            this.stereo = stereo;
        }

        @Override
        public void execute() {
            stereo.off();
        }

        @Override
        public void undo() {

        }
    }

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        /* 卧室灯 */
        Light livingRoomLight = new Light("Living Room");
        /* 厨房灯 */
        Light kitchenLight = new Light("Kitchen");
        /* 音响 */
        Stereo stereo = new Stereo();

        /* 卧室灯开关命令 */
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        /* 厨房灯开关命令 */
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        /* 音响开关 */
        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);

        /*
        * 命令设置到遥控器按钮
        * 卧室灯、厨房灯、音响
        * */
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCDCommand, stereoOffWithCDCommand);
        System.out.println(remoteControl.toString());

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPush(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPush(1);

        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPush(2);

    }
}
