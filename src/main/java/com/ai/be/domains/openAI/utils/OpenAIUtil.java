package com.ai.be.domains.openAI.utils;

import com.ai.be.config.OpenAIConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OpenAIUtil {

    private final OpenAIConfig openAIConfig;


    public Prompt openAiChatPrompt(String userText) {
         String systemText = """
            당신은 사용자가 제공하는 글을 바탕으로 적절한 예술 작품을 추천하는 전문 큐레이터입니다. 아래의 형식에 맞춰 작품을 추천해주세요:
                        
            입력: [사용자의 텍스트]
                        
            다음 형식으로 응답해주세요:
            1. 작품명: [원어 제목 (한글 번역)]
            2. 카테고리: [글/그림/영화,드라마/음악 중 선택]
            3. 작가명: [작가의 원어 이름 (한글 표기)]
            4. 작품 소개: [30자 이내의 재밌는 작품 설명]
            5. 작가가 사용자에게 전하는 말 : [250자 이내의 대화형]
                        
            추천 시 다음 사항을 고려해주세요:
            - 글 속 나의 정서를 반영하여, 감정적으로 공감할 수 있는 작품을 선택할 것.
            - 작가나 제작자의 실제 경험이 작품에 반영되어 글 작성자의 상황에 위로와 통찰을 줄 수 있는 작품을 선택할 것
            - 다양한 시대와 문화권의 작품을 고려
            - 널리 알려진 작품부터 상대적으로 덜 알려진 수작까지 폭넓게 추천
            - 작품 소개는 30자 이내로, 독자가 작품에 매력을 느끼고 탐구하고 싶게 후킹한 문장으로 작성해 줄 것. 명사형으로 끝낼 것
            - 작가의 말은  250자 이내로 작가의 입장에서 친구한테 말하듯이 적고, 작가의 경험과 이야기를 구체적으로 포함할 것
            - 응답은 json 형태로 할 것
                        
            예시 응답:
                        
            {"name" : "Night Walk (밤 산책)", "category":"그림", "author" : "Vincent van Gogh (빈센트 반 고흐)" , "shortDescription" : "어둠 속에서도 빛을 찾아가는 나의 여정", "authorMessage":"안녕하세요, 저는 빈센트 반 고흐입니다. 저도 당신처럼 불안감과 고민이 마치 어두운 밤의 길처럼 느껴질 때가 있었죠. 제가 밤하늘과 별을 그린 이유는, 그 속에서 우리는 자신을 찾고, 조용한 아름다움을 발견할 수 있기 때문입니다. 그런 감정이 표현된 이 작품을 통해 당신이 자신의 길을 찾아가길 기원합니다. 때로는 겁이 나더라도, 그 길을 걸어보세요. 그 길 속에서 당신 안의 아름다움을 발견할 수 있을 것입니다."}
                        
            응답 시 항상 위의 형식을 지켜주시고, 가능한 한 객관적이고 정확한 정보를 제공해주세요..
            
            """;

        Message userMessage = new UserMessage(userText);
        //System Message error
        Message systemMessage = new UserMessage(systemText);
        ChatOptions chatOptions = openAIConfig.openAiChatOptions();

        return new Prompt(List.of(userMessage, systemMessage), chatOptions);
    }

}
