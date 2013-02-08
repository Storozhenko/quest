package com.sam.quest.entity;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="answ_forms")
public class AnswForms {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="answ_id")
    private Long answId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="form_id")
    private Forms formId;
    @ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users userId;
    @Column(name="answ_datetime")
    private Timestamp answDatetime;

    public Long getAnswId() {
        return answId;
    }

    public void setAnswId(Long answId) {
        this.answId = answId;
    }

    public Forms getFormId() {
        return formId;
    }

    public void setFormId(Forms formId) {
        this.formId = formId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Timestamp getAnswDatetime() {
        return answDatetime;
    }

    public void setAnswDatetime(Timestamp answDatetime) {
        this.answDatetime = answDatetime;
    }
}
