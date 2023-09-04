package com.proyecto.yankiClient.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"identityNumber"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "client")
public class Client {
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private String identityNumber;

    @Indexed(unique = true)
    private String cellPhone;

    private String imei;

    private String email;

}