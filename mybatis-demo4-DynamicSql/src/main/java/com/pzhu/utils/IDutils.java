package com.pzhu.utils;

import java.util.UUID;

public class IDutils {

	public static String genId(){
return UUID.randomUUID().toString().replaceAll("-","");
}

}
