package com.util.module;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class UtilModule {

    private Class thisClass;

    final static int NAME = 0;
    final static int TYPE = 1;

    public UtilModule() {
    }

    public UtilModule(Class thisClass) {
        this.thisClass = thisClass;
    }

    /**
     *
     * @param thisClass : the class of which variables are to be obtained from
     * @return : dictionary of all variable names in thisClass
     */
    public ArrayList<DictModel> getFieldsName(Class thisClass){
        ArrayList<DictModel> result = new ArrayList<>();
        for (Field field : this.thisClass.getDeclaredFields()) {
            ArrayList<Serializable> props = new ArrayList<>();
            props.add(field.getName());
            props.add(field.getType());
            result.add(new DictModel(props));
        }

        return result;
    }

    public Object runMethod(Class<?> thisClass, String name){
        Object newInstance = null;
        Method newMethod = null;
        Object result = null;

        try {
           newInstance = thisClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if(newInstance != null) {
            try {
                newMethod = newInstance.getClass().getMethod(name);
                result = newMethod.invoke(newInstance);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     *
     * @return : dictionary of all variable names in thisClass
     */
    public ArrayList<DictModel> getFieldsName(){
        ArrayList<DictModel> result = new ArrayList<>();

        if(this.thisClass != null){
            for (Field field : this.thisClass.getDeclaredFields()) {
                ArrayList<Serializable> props = new ArrayList<>();
                props.add(field.getName());
                props.add(field.getType());
                result.add(new DictModel(props));
            }
        }

        return result;
    }
}
