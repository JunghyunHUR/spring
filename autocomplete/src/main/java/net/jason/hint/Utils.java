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
	
	//검색어 별로 스트림
	
	
	public static String list2Json(List<String> list) {
		String json = null;
		try {
			
			json = new ObjectMapper().writeValueAsString(list);
			
		}catch(JsonProcessingException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return json;
	}
	
	//json 타입으로 변환 (java 8 의 stream API를 이용하여)
}
