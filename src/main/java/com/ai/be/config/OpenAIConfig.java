package com.ai.be.config;


import org.springframework.ai.document.MetadataMode;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.retry.RetryUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
    @Value("${spring.ai.openai.api-key}")
    public String apiKey;

    public OpenAiApi openAiApi = new OpenAiApi(System.getenv("spring.ai.openai.api-key"));


    public OpenAiEmbeddingModel getEmbeddingModel() {
        return new OpenAiEmbeddingModel(
                this.openAiApi,
                MetadataMode.ALL,
                OpenAiEmbeddingOptions
                        .builder()
                        .withModel("text-embedding-ada-002")
                        .build(),
                RetryUtils.DEFAULT_RETRY_TEMPLATE
        );
    }


    @Bean
    public OpenAiChatOptions openAiChatOptions() {

        return OpenAiChatOptions.builder()
                .withModel("gpt-4o-mini")             // 모델 설정
                .withTemperature(1.0)              // 온도 설정
                .build();
    }





//    public OpenAiChatModel chatModel = new OpenAiChatModel(
//            this.openAiApi,
//            OpenAiChatOptions.builder()
//                    .withModel("gpt-4-o")
//                    .withTemperature(0.4)
//                    .build(),
//            RetryUtils.DEFAULT_RETRY_TEMPLATE
//    );

}
