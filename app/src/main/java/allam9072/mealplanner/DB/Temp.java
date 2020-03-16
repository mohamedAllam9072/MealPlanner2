package allam9072.mealplanner.DB;

import java.util.List;

public class Temp {
    String string1, string2;
    List<Temp> list;

    public Temp(String string1) {
        this.string1 = string1;
    }

    public Temp(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public Temp(String string1, String string2, List<Temp> list) {
        this.string1 = string1;
        this.string2 = string2;
        this.list = list;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public List<Temp> getList() {
        return list;
    }

    public void setList(List<Temp> list) {
        this.list = list;
    }
}
