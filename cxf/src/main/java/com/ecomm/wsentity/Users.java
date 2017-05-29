package com.ecomm.wsentity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

	@XmlElement(name="user")
    private List<User> userList; 

    public Users(){
    	this.userList = new ArrayList<User>();
    }
    
    public Users(List<User> userList){
    	this.userList = userList;
    }

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userItems) {
		this.userList = userItems;
	}
	
	public void addUser(User user) {
		this.userList.add(user);
	}

}
