package com.qianfeng.dao;

import com.qianfeng.pojo.Roleinfo;

public interface RoleinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    int insert(Roleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    int insertSelective(Roleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    Roleinfo selectByPrimaryKey(Integer roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Roleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roleinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Roleinfo record);
}