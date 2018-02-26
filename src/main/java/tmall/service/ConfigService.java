package tmall.service;

import java.util.Map;

public interface ConfigService extends BaseService{
    //获取参数的键值对
    public Map<String,String> map() throws Exception;
}