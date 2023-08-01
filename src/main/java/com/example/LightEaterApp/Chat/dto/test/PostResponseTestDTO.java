package com.example.LightEaterApp.Chat.dto.test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//http응답으로 사용
public class PostResponseTestDTO {
    private String error;                   //에러메세지를 보내줌
    private String userId;
    private String chatId;
    private String chatWords;
    private int resultNum;
}
