import java.awt.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dogs extends Animals{

    public Dogs(String typeName, String nickname, ArrayList<String>commands, String birthday) {
        super(typeName, nickname, commands, birthday);
    }

    @Override
    public String getNickname() {
        return super.getNickname();
    }

    @Override
    public String getCommands() {
        return super.getCommands();
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }

    @Override
    public void setBirthday(String birthday) {
        super.setBirthday(birthday);
    }

    @Override
    public String getTypeName() {
        return super.getTypeName();
    }

    @Override
    public void setTypeName(String typeName) {
        super.setTypeName(typeName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
