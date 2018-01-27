package com.lmgd.customer.util;

import java.io.InputStream;
import java.io.OutputStream;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper objectMapper;

	static {
		try {
			objectMapper = new ObjectMapper();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @java-->Json
	 * @将java对象--转成-->Json字符串/对象并输出
	 * 
	 * @param value
	 * @param is
	 */
	public static void writeValue(Object value, OutputStream os) {
		// writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
		// jsonGenerator.writeObject(bean);

		try {
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory()
					.createJsonGenerator(os, JsonEncoding.UTF8);
			// writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
			jsonGenerator.writeObject(value);

			// 这个不要也没事
			if (jsonGenerator != null) {
				jsonGenerator.flush();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
