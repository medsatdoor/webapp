package com.ecomm.wsentity;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="members")
@XmlAccessorType(XmlAccessType.FIELD)
public class Members {

	@XmlElement(name="member")
	private List<Member> memberList; 
	
	public Members(){
    	this.memberList = new ArrayList<Member>();
    }
	
	public Members(List<Member> memberList){
    	this.memberList = memberList;
    }

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
	public void addMember(Member member) {
		this.memberList.add(member);
	}
}
