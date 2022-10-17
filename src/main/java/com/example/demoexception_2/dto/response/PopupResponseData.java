package com.example.demoexception_2.dto.response;

import lombok.Data;

@Data
public class PopupResponseData {

    /**
     * Tieu de cua popup
     */
    private String title;

    /**
     * noi dung cua popup
     */
    private String content;

    private String leftButton;

    private String rightButton;

}
