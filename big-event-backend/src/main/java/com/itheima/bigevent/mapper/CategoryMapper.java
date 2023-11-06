package com.itheima.bigevent.mapper;

import com.itheima.bigevent.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category(category_name, category_alias,create_user, create_time, update_time) " +
            "values(#{categoryName},#{categoryAlias},#{createUser},now(),now())")
    void add(final Category category);

    @Select("select * from category where create_user=#{id}")
    List<Category> list(final Integer id);

    @Select("select * from category where id=#{id}")
    Category findById(final Integer id);

    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=now() where id=#{id}")
    void update(final Category category);

    @Delete("delete from category where id=#{id}")
    void delete(final Integer id);
}
