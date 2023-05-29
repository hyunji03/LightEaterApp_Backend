package com.example.LightEaterApp.Chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Chat")
public class ChatEntity {
    @Id
    //chatId는 자동 생성
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String chatId;
    private String userId;
    //1학기 임시 테스트용 - 문장 주고 받기
    private String chatWords;       //다희언니에게 변수명 물어보기
    private int resultNum;

/*
    private String relation;
    private String chatFiles;
    private String[] chatImage;
    private String[] gSentence;
    private int resultNum;
    private Date chatDate;
*/
}
