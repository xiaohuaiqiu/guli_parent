package com.zhq.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhq.guli.service.base.config.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author 张怀秋先生
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("edu_teacher")
@ApiModel(value = "Teacher对象", description = "讲师")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师姓名", example = "皮皮刘老师")
    private String name;

    @ApiModelProperty(value = "讲师简介", example = "星海音乐学院流行声乐老师,火锅流行音乐教师团队之一,消防通道阿卡拉贝乐队主唱")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师", example = "深入浅出,有点神经的教学方式深入人心,幽默风趣!")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "入驻时间", example = "2023-02-25")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //个性化时间格式
    private Date joinDate;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
