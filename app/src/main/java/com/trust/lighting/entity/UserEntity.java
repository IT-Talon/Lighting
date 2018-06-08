package com.trust.lighting.entity;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/8.
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5119972734946603997L;
    /**
     * id : 1
     * mch_id : 9
     * name : 杨晓智
     * token : 3cf4cc40325f11e885ebc89cdcee1044
     * telephone : 13271279565
     * identify : 1
     * has_mod : 0
     */

    private int id;
    private int mch_id;
    private String name;
    private String token;
    private String telephone;
    private int identify;
    private int has_mod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMch_id() {
        return mch_id;
    }

    public void setMch_id(int mch_id) {
        this.mch_id = mch_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public int getHas_mod() {
        return has_mod;
    }

    public void setHas_mod(int has_mod) {
        this.has_mod = has_mod;
    }
}
