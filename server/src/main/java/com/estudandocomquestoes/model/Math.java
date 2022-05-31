package com.estudandocomquestoes.model;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Matematica")
public class Math {

    @Id
    private String id;

    @Nullable
    @Field
    private String subject;

    @Nullable
    @Field
    private String question;

    @Nullable
    @Field
    private String alternativeA;

    @Nullable
    @Field
    private String alternativeB;

    @Nullable
    @Field
    private String alternativeC;

    @Nullable
    @Field
    private String alternativeD;

    @Nullable
    @Field
    private String alternativeE;

    @Nullable
    @Field
    private String correct;

}
