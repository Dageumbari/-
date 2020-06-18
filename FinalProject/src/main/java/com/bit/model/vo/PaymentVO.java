package com.bit.model.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentVO {
	private String sid;
	private String DashboardCode;
	private Date approved_at;
	private int total_amount;
	private String item_name;
	private String bin_card_info;
	private String purchase_corp;
	private String status;
	private Date planEndDate; 
}
