package cn.desc.www.util.json;

import java.io.StringWriter;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectUtil {
  /** 
   * 将json字符串转换成实体POJO 
   *  
   * @param jsonStr 
   * @param obj 
   * @return 
   * @throws Exception 
   */  
  public static <T> Object JSONToObj(String jsonStr, Class<T> obj)  
          throws Exception {  
      T t = null;  
      ObjectMapper objectMapper = new ObjectMapper();  
      t = objectMapper.readValue(jsonStr, obj);  
      return t;  
  }  

  /** 
   * 将实体POJO转化为JSON对象 该方法不要用于将List<T>对象转换成json对象 
   * 因为如果对象的字段中有java.sql.Date类型的字段的话会报错 如果是单个对象T，是没有问题的 
   * 如果需要将List<T>对象转换成json的话，请用objectToJsonStr()方法 
   *  
   * @param obj 
   * @return 
   * @throws Exception 
   */  
  public static <T> JSONObject objectToJson(T obj) throws Exception {  
      if (null == obj)  
          return new JSONObject();  
      ObjectMapper mapper = new ObjectMapper();  
      String jsonStr = mapper.writeValueAsString(obj);  
      return new JSONObject(jsonStr);  
  }  

  /** 
   * 将Object对象转换成JSON字符串 这种方法可以将java.sql.Date字段转换成字符串时间，如"2016-05-09" 
   * 将java.util.Date字段转换成时间戳，如1462774004169 
   * 将java.sql.Timestamp字段转成成时间戳，如1462774004169 
   * {"utilDate":1462774004169,"sqlDate" 
   * :"2016-05-09","timestamp":1462774004169} 
   *  
   * @param <T> 
   *  
   * @param obj 
   * @return 
   * @throws Exception 
   */  
  public static <T> String objectToJsonStr(T obj) throws Exception {  
      if (null == obj)  
          return new JSONObject().toString();  
      StringWriter str = new StringWriter();  
      ObjectMapper mapper = new ObjectMapper();  
      mapper.writeValue(str, obj);  
      return str.toString();  
  }  
}
