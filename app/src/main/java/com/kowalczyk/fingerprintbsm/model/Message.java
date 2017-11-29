package com.kowalczyk.fingerprintbsm.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by JKowalczyk on 2017-11-29.
 */
@Entity
public class Message {

    @Id(autoincrement = true)
    private Long id;

    private String message;

    @Generated(hash = 149132832)
    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    @Generated(hash = 637306882)
    public Message() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
