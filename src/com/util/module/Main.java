package com.util.module;

import static com.util.module.UtilModule.NAME;

public class Main {
    public String name = "Emmanuel";
    public int age = 18;
    public boolean isMale = true;

    public int getAge(){
        return age;
    }
    public static void main(String[] args) {
        UtilModule utilString = new UtilModule(Main.class);
        for(DictModel model : utilString.getFieldsName()){
            System.out.println(model.getProps().get(NAME));
        }

        System.out.println(String.valueOf(utilString.runMethod(Main.class, "getAge")));
    }
}
