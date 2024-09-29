import java.awt.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract public class Animals extends AnimalsType{
    private final String nickname;
    private final ArrayList<String> commands;
    private String birthday;

    public Animals(String typeName, String nickname, ArrayList<String> commands, String birthday) {
        super(typeName);
        this.nickname = nickname;
        this.commands = commands;
        this.birthday = birthday;
    }


    public String getNickname() {
        return nickname;
    }

    public String getCommands() {
        return commands.toString();
    }

    private void setCommands(String commands) {
        this.commands.add(commands);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Тип животного = " + super.getTypeName() +
                "; кличка = " + nickname +
                "; выполняемые команды = " + commands +
                "; дата рождения = " + birthday + '\n';
    }
}

