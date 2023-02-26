package com.zhq.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.guli.service.base.config.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author 张怀秋先生
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("edu_subject")
@ApiModel(value="Subject对象", description="课程科目")
public class Subject extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;


}
