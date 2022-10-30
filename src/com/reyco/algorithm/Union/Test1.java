package com.reyco.algorithm.Union;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 并查集运用一：
 * git账号有三个属性:id、手机号、用户名，只要两个账号之间任意一个属性相同就代表同一个人,求给定List账号有几个人？
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		List<User> users = createRandomUsers(10);
		for (User user : users) {
			System.out.println(user);
		}
		int person = getPerson(users);
		System.out.println(person);
	}
	public static int getPerson(List<User> users) {
		UserUnionFind union = new UserUnionFind(users);
		Map<String,User> idMap = new HashMap<String,User>();
		Map<String,User> phoneMap = new HashMap<String,User>();
		Map<String,User> usernameMap = new HashMap<String,User>();
		for (User user : users) {
			if(idMap.containsKey(user.id)) {
				union.union(user, idMap.get(user.id));
			}else {
				idMap.put(user.id, user);
			}
			if(phoneMap.containsKey(user.phone)) {
				union.union(user, phoneMap.get(user.phone));
			}else {
				phoneMap.put(user.phone, user);
			}
			if(usernameMap.containsKey(user.username)) {
				union.union(user, usernameMap.get(user.username));
			}else {
				usernameMap.put(user.username, user);
			}
		}
		return union.getUserSize();
		
	}
	public static class UserUnionFind extends UnionFind<User>{
		
		public UserUnionFind(Collection<User> values) {
			super(values);
		}

		public int getUserSize(){
			return getSize().size();
		}
	}
	
	public static class User{
		String id;
		String phone;
		String username;
		public User(String id, String phone, String username) {
			super();
			this.id = id;
			this.phone = phone;
			this.username = username;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", phone=" + phone + ", username=" + username + "]";
		}
	}
	
	
	
	public static List<User> createRandomUsers(int size){
		Random random = new Random();
		List<User> users = new ArrayList<>();
		User user = null;
		for (int i=1;i<=size;i++) {
			user = new User(random.nextInt(100)+"", "183072002"+random.nextInt(10)+1, "zhang"+random.nextInt(10));
			users.add(user);
		}
		return users;
	}
	
}
