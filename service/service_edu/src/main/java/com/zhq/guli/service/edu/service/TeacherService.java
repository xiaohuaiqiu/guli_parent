package com.zhq.guli.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhq.guli.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhq.guli.service.edu.entity.vo.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 张怀秋先生
 * @since 2023-02-25
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 带条件查询分页查询讲师
     * @param pageParam
     * @param teacherQueryVo
     * @return
     */
    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);
}
