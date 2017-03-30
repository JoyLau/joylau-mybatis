/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.entity;

import cn.joylau.mybatis.mapper.MapperException;
import cn.joylau.mybatis.mapper.util.StringUtil;
import org.apache.ibatis.mapping.ResultFlag;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.Configuration;

import javax.persistence.Table;
import java.util.*;

/**
 * 数据库表
 *
 */
public class EntityTable {
    private String name;
    private String catalog;
    private String schema;
    private String orderByClause;
    private String baseSelect;
    //实体类 => 全部列属性
    private Set<EntityColumn> entityClassColumns;
    //实体类 => 主键信息
    private Set<EntityColumn> entityClassPKColumns;
    //useGenerator包含多列的时候需要用到
    private List<String> keyProperties;
    private List<String> keyColumns;
    //resultMap对象
    private ResultMap resultMap;
    //属性和列对应
    protected Map<String, EntityColumn> propertyMap;
    //类
    private Class<?> entityClass;

    public EntityTable(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public void setTable(Table table) {
        this.name = table.name();
        this.catalog = table.catalog();
        this.schema = table.schema();
    }

    public void setKeyColumns(List<String> keyColumns) {
        this.keyColumns = keyColumns;
    }

    public void setKeyProperties(List<String> keyProperties) {
        this.keyProperties = keyProperties;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getBaseSelect() {
        return baseSelect;
    }

    public void setBaseSelect(String baseSelect) {
        this.baseSelect = baseSelect;
    }

    public String getPrefix() {
        if (StringUtil.isNotEmpty(catalog)) {
            return catalog;
        }
        if (StringUtil.isNotEmpty(schema)) {
            return schema;
        }
        return "";
    }

    public Set<EntityColumn> getEntityClassColumns() {
        return entityClassColumns;
    }

    public void setEntityClassColumns(Set<EntityColumn> entityClassColumns) {
        this.entityClassColumns = entityClassColumns;
    }

    public Set<EntityColumn> getEntityClassPKColumns() {
        return entityClassPKColumns;
    }

    public void setEntityClassPKColumns(Set<EntityColumn> entityClassPKColumns) {
        this.entityClassPKColumns = entityClassPKColumns;
    }

    public String[] getKeyProperties() {
        if (keyProperties != null && keyProperties.size() > 0) {
            return keyProperties.toArray(new String[]{});
        }
        return new String[]{};
    }

    public void setKeyProperties(String keyProperty) {
        if (this.keyProperties == null) {
            this.keyProperties = new ArrayList<String>();
            this.keyProperties.add(keyProperty);
        } else {
            this.keyProperties.add(keyProperty);
        }
    }

    public String[] getKeyColumns() {
        if (keyColumns != null && keyColumns.size() > 0) {
            return keyColumns.toArray(new String[]{});
        }
        return new String[]{};
    }

    public void setKeyColumns(String keyColumn) {
        if (this.keyColumns == null) {
            this.keyColumns = new ArrayList<String>();
            this.keyColumns.add(keyColumn);
        } else {
            this.keyColumns.add(keyColumn);
        }
    }

    /**
     * 生成当前实体的resultMap对象
     *
     * @param configuration
     * @return
     */
    public ResultMap getResultMap(Configuration configuration) {
        if (this.resultMap != null) {
            return this.resultMap;
        }
        if (entityClassColumns == null || entityClassColumns.size() == 0) {
            return null;
        }
        List<ResultMapping> resultMappings = new ArrayList<ResultMapping>();
        for (EntityColumn entityColumn : entityClassColumns) {
            ResultMapping.Builder builder = new ResultMapping.Builder(configuration, entityColumn.getProperty(), entityColumn.getColumn(), entityColumn.getJavaType());
            if (entityColumn.getJdbcType() != null) {
                builder.jdbcType(entityColumn.getJdbcType());
            }
            if (entityColumn.getTypeHandler() != null) {
                try {
                    builder.typeHandler(entityColumn.getTypeHandler().newInstance());
                } catch (Exception e) {
                    throw new MapperException(e);
                }
            }
            List<ResultFlag> flags = new ArrayList<ResultFlag>();
            if (entityColumn.isId()) {
                flags.add(ResultFlag.ID);
            }
            builder.flags(flags);
            resultMappings.add(builder.build());
        }
        ResultMap.Builder builder = new ResultMap.Builder(configuration, "BaseMapperResultMap", this.entityClass, resultMappings, true);
        this.resultMap = builder.build();
        return this.resultMap;
    }

    /**
     * 初始化 - Example 会使用
     */
    public void initPropertyMap() {
        propertyMap = new HashMap<String, EntityColumn>(getEntityClassColumns().size());
        for (EntityColumn column : getEntityClassColumns()) {
            propertyMap.put(column.getProperty(), column);
        }
    }

    public Map<String, EntityColumn> getPropertyMap() {
        return propertyMap;
    }
}
