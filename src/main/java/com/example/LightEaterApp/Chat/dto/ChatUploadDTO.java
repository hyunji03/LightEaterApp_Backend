package com.example.LightEaterApp.Chat.dto;

import com.example.LightEaterApp.Chat.model.ChatEntity;
import com.example.LightEaterApp.Chat.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatUploadDTO {
    //!!!!!!!임시 테스트용 !!!!!!!!//
    private String chatWords;

    //private String chatId;
    //private String userId;
    private int resultNum;
    private int relation;

    //나중에 chatWords 대체
    //private String chatText;
    //private Date chatDate;
    
    //private String doubtSentence;
    

    private float avoidScore;
    private float anxietyScore;
    private int testType;
    private String doubtText1;
    private String doubtText2;
    private String doubtText3;
    private String doubtText4;
    private String doubtText5;


//의심문장 12345추가

    public ChatUploadDTO(final ChatEntity chatEntity,UserEntity userEntity) {
        //!!!!!!!임시!!!!!!!//
        this.chatWords = chatEntity.getChatWords();

        //this.chatId = chatEntity.getChatId();
        //this.userId = chatEntity.getUserId();
        this.resultNum = chatEntity.getResultNum();
        this.relation = chatEntity.getRelation();
        //this.chatText = chatEntity.getChatText();
        //this.chatDate = chatEntity.getChatDate();
        //this.doubtSentence = chatEntity.getDoubtSentence();

        this.avoidScore = userEntity.getAvoidScore();
        this.anxietyScore = userEntity.getAnxietyScore();
        this.testType = userEntity.getTestType();
        this.doubtText1 ="doubtText1";
        this.doubtText2 ="doubtText2";
        this.doubtText3 ="doubtText3";
        this.doubtText4 ="doubtText4";
        this.doubtText5 ="doubtText5";


    }



    public ChatUploadDTO(final ChatEntity chatEntity) {
        //!!!!!!!임시!!!!!!!//
        this.chatWords = chatEntity.getChatWords();

        //this.chatId = chatEntity.getChatId();
        //this.userId = chatEntity.getUserId();
        this.resultNum = chatEntity.getResultNum();
        this.relation = chatEntity.getRelation();
        //this.chatText = chatEntity.getChatText();
       // this.chatDate = chatEntity.getChatDate();
        //this.doubtSentence = chatEntity.getDoubtSentence();
        /*
        this.avoidScore = userEntity.getAvoidScore();
        this.anxietyScore = userEntity.getAnxietyScore();
        this.testType = userEntity.getTestType();

         */
    }
    public ChatUploadDTO(final UserEntity userEntity) {
        //!!!!!!!임시!!!!!!!//
        /*
        this.chatWords = chatEntity.getChatWords();

        //this.chatId = chatEntity.getChatId();
        this.userId = chatEntity.getUserId();
        this.resultNum = chatEntity.getResultNum();
        this.relation = chatEntity.getRelation();
        //this.chatText = chatEntity.getChatText();
        this.chatDate = chatEntity.getChatDate();
        //this.doubtSentence = chatEntity.getDoubtSentence();

         */
        this.avoidScore = userEntity.getAvoidScore();
        this.anxietyScore = userEntity.getAnxietyScore();
        this.testType = userEntity.getTestType();
    }

    //DTO를 받아서 저장
    public static ChatEntity toChatEntity(final ChatUploadDTO dto) {
        return ChatEntity.builder()
                .chatWords(dto.getChatWords())
                //.chatId(dto.getChatId())
                //.userId(dto.getUserId())
                .resultNum(dto.getResultNum())
                .relation(dto.getRelation())
                //.chatText(dto.getChatText())
                //.chatDate(dto.getChatDate())
                //.doubtSentence(dto.getDoubtSentence())
                .build();
    }

    public static UserEntity toUserEntity(final ChatUploadDTO dto) {
        return UserEntity.builder()
                //.userId(dto.getUserId())
                .avoidScore(dto.getAvoidScore())
                .anxietyScore(dto.getAnxietyScore())
                .build();
    }
    // ChatResponseBodyDTO로 매핑하는 메서드 추가
    public ChatResponseBodyDTO toChatResponseBodyDTO(final ChatUploadDTO chatUploadDTO) {
        ChatResponseBodyDTO chatResponseBodyDTO = new ChatResponseBodyDTO(chatUploadDTO);

        return chatResponseBodyDTO;
    }
}

