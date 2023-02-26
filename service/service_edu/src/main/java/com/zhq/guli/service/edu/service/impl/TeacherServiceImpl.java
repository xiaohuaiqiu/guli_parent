package com.zhq.guli.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhq.guli.service.edu.entity.Teacher;
import com.zhq.guli.service.edu.entity.vo.TeacherQueryVo;
import com.zhq.guli.service.edu.mapper.TeacherMapper;
import com.zhq.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 张怀秋先生
 * @since 2023-02-25
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * 带条件查询分页查询讲师
     *
     * @param pageParam
     * @param teacherQueryVo
     * @return
     */
    @Override
    public IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo) {

        //显示分页查询列表
//        1、排序：按照sort字段排序
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

//        2、分页查询
        if (teacherQueryVo == null) {
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

//        3、条件查询
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.likeRight("name", name); //模糊查询
        }

        if (level != null) {
            queryWrapper.eq("level", level); //确定查询
        }

        if (!StringUtils.isEmpty(joinDateBegin)) {
            queryWrapper.ge("join_date", joinDateBegin); //区域查询
        }

        if (!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le("join_date", joinDateEnd); //区域查询
        }

        return baseMapper.selectPage(pageParam, queryWrapper); //返回带分页参数和条件的查询结果
    }
}
