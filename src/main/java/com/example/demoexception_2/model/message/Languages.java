package com.example.demoexception_2.model.message;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "languages")
public class Languages {
    @Id
    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "name")
    private String name;

    public Languages(String languageCode) {
        this.languageCode = languageCode;
    }

    public Languages() {

    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
