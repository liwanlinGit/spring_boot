package cn.desc.www.util;

public class ExceptionUtil extends RuntimeException  {
	protected String key;
  protected Object[] args;
  public ExceptionUtil(String key)
  {
      super(key);
      this.key = key;
  }
  
  public  ExceptionUtil(String key, Throwable cause)
  {
      super(key, cause);
      this.key = key;
  }
  

  public  ExceptionUtil(String key,  Object ... args)
  {
      super(key);
      this.key = key;
      this.args = args;
  }
  

  public  ExceptionUtil(String key, Throwable cause, Object ... args)
  {
      super(key, cause);
      this.key = key;
      this.args = args;
  }

  public String getKey()
  {
      return key;
  }

  public Object[] getArgs()
  {
      return args;
  }

}
