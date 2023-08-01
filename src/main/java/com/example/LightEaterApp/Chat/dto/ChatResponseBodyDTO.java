package com.example.LightEaterApp.Chat.dto;

import com.example.LightEaterApp.Chat.model.ChatEntity;
import com.example.LightEaterApp.Chat.model.UserEntity;

public class ChatResponseBodyDTO {
    private int resultNum;
    private float avoidScore;
    private float anxietyScore;
    private int testType;
    private String doubtText1;
    private String doubtText2;
    private String doubtText3;
    private String doubtText4;
    private String doubtText5;

    public ChatResponseBodyDTO (final ChatUploadDTO chatUploadDTO) {
        this.resultNum = chatUploadDTO.getResultNum();
        this.avoidScore = chatUploadDTO.getAvoidScore();
        this.anxietyScore = chatUploadDTO.getAnxietyScore();
        this.testType = chatUploadDTO.getTestType();
        this.doubtText1 ="doubtText1";
        this.doubtText2 ="doubtText2";
        this.doubtText3 ="doubtText3";
        this.doubtText4 ="doubtText4";
        this.doubtText5 ="doubtText5";
    }


    public ChatResponseBodyDTO (final ChatEntity chatEntity) {
        this.resultNum = chatEntity.getResultNum();
        //this.avoidScore = userEntity.getAvoidScore();
        //this.anxietyScore = userEntity.getAnxietyScore();
        //this.testType = userEntity.getTestType();
        this.doubtText1 ="doubtText1";
        this.doubtText2 ="doubtText2";
        this.doubtText3 ="doubtText3";
        this.doubtText4 ="doubtText4";
        this.doubtText5 ="doubtText5";
    }
    public ChatResponseBodyDTO (final UserEntity userEntity) {
        //this.resultNum = chatEntity.getResultNum();
        this.avoidScore = userEntity.getAvoidScore();
        this.anxietyScore = userEntity.getAnxietyScore();
        this.testType = userEntity.getTestType();
        this.doubtText1 ="doubtText1";
        this.doubtText2 ="doubtText2";
        this.doubtText3 ="doubtText3";
        this.doubtText4 ="doubtText4";
        this.doubtText5 ="doubtText5";
    }
}
