package cn.joylau.mybatis.mapper.function;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LiuFa on 2017/4/5.
 * cn.joylau.mybatis.mapper.base
 * greatapp
 */
public class FunctionModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Date createTime;

    @Transient
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
