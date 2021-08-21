package lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> hm = new HashMap<>();
		
		for (int i = 0; i < record.length; i++) {
			String input = record[i];
			String[] command = input.split(" ");

			String tmp = "";
			switch (command[0]) {
			case "Enter":
				if(hm.containsKey(command[1])) hm.replace(command[1], command[2]); // 존재하면 있는 거 수정
				else hm.put(command[1], command[2]);  // 존재하지 않으면 새로 추가
				tmp += (command[1] + ",enter");
				break;
			case "Leave":
				tmp += (command[1] + ",leave");
				break;
			case "Change":
				hm.replace(command[1], command[2]);
				break;
			}
			if(!command[0].equals("Change")) list.add(tmp);
		}
		
		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String tmp = list.get(i);
			String[] tmpArr = tmp.split(",");	// 고유ID, Enter
			String output = tmpArr[1].equals("enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
			output = hm.get(tmpArr[0]) + output;
			// System.out.println(output);
			result[i] = output;
		}
		
	}
}
