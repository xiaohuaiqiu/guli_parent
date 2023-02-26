package com.zhq.guli.service.edu.controller.admin;


import com.zhq.guli.common.base.result.R;
import com.zhq.guli.service.edu.entity.Teacher;
import com.zhq.guli.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 后台管理系统
 * </p>
 *
 * @author 张怀秋先生
 * @since 2023-02-25
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("讲师展示接口")
    @GetMapping("list")
    public R teacherList() {
        List<Teacher> list = teacherService.list();
        return R.ok().data("讲师数据", list);
    }

    @ApiOperation(value = "讲师移除接口", notes = "根据id删除讲师,逻辑删除")
    @DeleteMapping("remove/{id}")
    public R remove(@ApiParam("讲师ID") @PathVariable String id) {
        boolean result = teacherService.removeById(id);
        if (result != false) {
            return R.ok().message("删除成功!");
        } else {
            return R.error().message("数据已经删除或者不存在!");
        }
    }


}

