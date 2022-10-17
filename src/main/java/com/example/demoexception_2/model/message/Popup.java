package com.example.demoexception_2.model.message;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@Table(name = "popup")
public class Popup {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "lang_code")
    private String langCode;

    @Column(name = "btn_id")
    private Integer btnId;

    @Column(name = "title")
    private String title;

    public Popup(Integer id) {
        this.id = id;
    }

    public Popup() {

    }
    //    @ManyToOne
//    @JoinColumn(name = "btn_id")
//    private PopupBtn popupBtn;
//
//    public PopupBtn getPopupBtn() {
//        return popupBtn;
//    }
//
//    public void setPopupBtn(PopupBtn popupBtn) {
//        this.popupBtn = popupBtn;
//    }

//    @Override
//    public String toString() {
//        return "Popup{" +
//                "messageId=" + messageId +
//                ", langCode='" + langCode + '\'' +
//                ", title='" + title + '\'' +
//                ", popupBtn=" + '\'' +
//                ", buttonLeft=" + popupBtn.getBtnLeft() +'\'' +
//                ", buttonRight=" + popupBtn.getBtnRight() + '\'' +
//                '}';
//    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getLangCode() {
        return this.langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public Integer getBtnId() {
        return this.btnId;
    }

    public void setBtnId(Integer btnId) {
        this.btnId = btnId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
