package commandpattern;

/*
 * 命令模式
 *
 * 实现遥控器很多个
 * */
public class CommandPattern {

    public interface Command {
        public void execute();
    }

    public static class LightOnCommand implements Command {
        Light light;
        public LightOnCommand(Light light){
            this.light = light;
        }
        @Override
        public void execute() {
            light.on();
        }
    }

    static class Light {
        void on() {
            System.out.println("Light is on()");
        }

        void off() {
            System.out.println("Light is off()");
        }
    }

    static class SimpleRemoteControl {
        Command slot;
        public SimpleRemoteControl() {}
        public void setCommand(Command command) {
            slot = command;
        }
        public void buttonWasPressed() {
            slot.execute();
        }
    }

    public static void main(String[] args) {
        /* 创建调用者 */
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();
    }
}
