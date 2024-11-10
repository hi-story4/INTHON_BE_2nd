package com.ai.be.domains.openAI.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class OpenAIChat {

    private String name;
    private String category;
    private String author;
    private String shortDescription;
    private String authorMessage;

}
