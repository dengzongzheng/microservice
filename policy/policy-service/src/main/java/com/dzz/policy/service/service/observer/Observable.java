package com.dzz.policy.service.service.observer;

import java.util.Vector;

/**
 * 观察者组
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月14 17:03
 */
public class Observable {

    /**
     * 观察者容器存放
     */
    private Vector<AbstractObserver> obVector = new Vector<>();

    /**
     * 新增观察者
     * @param observer 观察者
     */
    public void addObserver(AbstractObserver observer) {

        this.obVector.add(observer);
    }


    /**
     * 删除观察者
     * @param observer 观察者
     */
    public void delObserver(AbstractObserver observer) {
        this.obVector.remove(observer);
    }

    //通知所有观察者

    /**
     * 通知所有观察者
     * @param proposalNo proposalNo
     */
    public void notifyObservers(String proposalNo) {
        obVector.forEach(s -> s.apply(proposalNo));
    }

}
