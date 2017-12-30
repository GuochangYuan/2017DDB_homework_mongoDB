package common.util;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * 日期反序列化实用工具类
 * @Desctiption 
 * @author huanghm
 * @date 2012-2-8
 * @version 
 * @history
 * @param
 */
public class DateDeserializerUtils implements JsonDeserializer<java.util.Date>{

	@Override
	public Date deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
	}

}
