package bupt.renying.microblog.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
    private Class<T> classType;
    public BeanListHandler(Class<T> classType) {
        this.classType = classType;
    }
    

    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        while(rs.next()) {
            //根据字节码创建一个对象
            T obj = classType.newInstance();
            
            //根据字节码用Introspector拿到对应类的属性
            BeanInfo beanInfo = Introspector.getBeanInfo(this.classType);
            
            //获取所有属性的描述器
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            
            //遍历每个属性的描述器
            for(PropertyDescriptor pd: pds) {
                //这里属性名必须和数据库表内的的字段名相同
                Object val = rs.getObject(pd.getName());
                
                //给对象设置属性值
                pd.getWriteMethod().invoke(obj, val);
            }
            list.add(obj);
        }
        return list;
    }
}
