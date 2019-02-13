package com.weekly.json;

import java.util.HashMap;
import java.util.Map;

public class StatusObject {
	public static final Map<String, Object> STATUS_OK = new HashMap<String, Object>(){
		
		private static final long serialVersionUID = 2299444684948960606L;

		{
			put("code", 200); 
			put("msg", "ok");  
		}
		
	};
}
