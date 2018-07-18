package com.springboot.mybatis.pojo;

import javax.persistence.*;

public class Girl {
    @Id
    private Integer id;

    private Integer age;

    @Column(name = "cup_size")
    private String cupSize;

    private Double money;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return cup_size
     */
    public String getCupSize() {
        return cupSize;
    }

    /**
     * @param cupSize
     */
    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    /**
     * @return money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }
}