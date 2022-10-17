package com.example.demoexception_2.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "popup_btn")
public class PopupBtn {
    @Id
    @Column(name = "popup_btn_id")
    private Integer popupBtnId;

    @Column(name = "lang_id")
    private String langId;

    @Column(name = "btn_left")
    private String btnLeft;

    @Column(name = "btn_right")
    private String btnRight;

    public PopupBtn() {

    }

    public Integer getPopupBtnId() {
        return this.popupBtnId;
    }

    public void setPopupBtnId(Integer popupBtnId) {
        this.popupBtnId = popupBtnId;
    }

    public String getLangId() {
        return this.langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getBtnLeft() {
        return this.btnLeft;
    }

    public void setBtnLeft(String btnLeft) {
        this.btnLeft = btnLeft;
    }

    public String getBtnRight() {
        return this.btnRight;
    }

    public void setBtnRight(String btnRight) {
        this.btnRight = btnRight;
    }
}
