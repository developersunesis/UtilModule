package com.util.module;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * DictModel.class
 * To create models for the properties od the field to be obtained
 */

public class DictModel {
    private ArrayList<Serializable> props;

    DictModel(ArrayList<java.io.Serializable> props) {
        this.props = props;
    }

    public ArrayList<java.io.Serializable> getProps() {
        return props;
    }

    public void setProps(ArrayList<java.io.Serializable> props) {
        this.props = props;
    }
}
