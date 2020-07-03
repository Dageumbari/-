package com.bit.model.dto.space;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("draftList")
public class DraftListDTO {
   private String spaceCode;
   private String draftCode;
   private Timestamp draftSavetime;
   private String draftStatus;
   private int msgNo;
   private String msgContent;
   private int editsCount;
   private String name;
   private String userImage;

}
