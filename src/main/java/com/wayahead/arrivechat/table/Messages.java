package com.wayahead.arrivechat.table;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    private String msgBy;
    private String text;
    private String translatedText;
    private String language;
    private String time;
}