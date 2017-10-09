package com.epam.javaacademy;

import java.util.Iterator;
import java.util.Map;

public class Statistics implements Action {

	@Override
	public void doSomething(Input input) {

		Iterator it=Utils.sCounter.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair=(Map.Entry)it.next();
			System.out.println(pair.getKey()+":"+pair.getValue());
		}
		
	}

}
