package net.jason.hint;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
  
	public static List<String> filterListByTerm(List<String> list, String term) {
    	
    	List<String> matching = list.stream()
    			                .filter( e-> e.toLowerCase().startsWith(term))
    			                .collect(Collectors.toList());
    	return matching;
    	
    }
	
	//�˻��� ���� ��Ʈ��
	
	
	public static String list2Json(List<String> list) {
		String json = null;
		try {
			
			json = new ObjectMapper().writeValueAsString(list);
			
		}catch(JsonProcessingException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return json;
	}
	
	//json Ÿ������ ��ȯ (java 8 �� stream API�� �̿��Ͽ�)
}
