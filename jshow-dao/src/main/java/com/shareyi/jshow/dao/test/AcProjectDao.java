package com.shareyi.jshow.dao.test;

import com.shareyi.jshow.domain.test.AcProject;
import com.shareyi.jshow.dao.BaseDao;
import java.util.List;
import java.util.Map;

/**
 * AcProject Dao接口类
 *
 * @author MoliCode
 * @date 2019-05-04
 */
public interface AcProjectDao extends BaseDao<AcProject> {

  /**
   * * 根据主键，获取到明细
   *
   * @param id
   * @return
   */
  @Override
  AcProject getByPk(Long id);

  /**
   * * 条件查询,最大1000条
   *
   * @param params
   * @return
   */
  @Override
  List<AcProject> getListByExample(Map<String, Object> params);

  /**
   * * 分页条件查询
   *
   * @param params
   * @return
   */
  @Override
  List<AcProject> queryByPage(Map<String, Object> params);

  /**
   * * 分页查询行数，一定要传入分页信息
   *
   * @param params
   * @return
   */
  @Override
  Long count(Map<String, Object> params);

  /**
   * * 修改数据
   *
   * @param obj
   * @return
   */
  @Override
  int update(AcProject obj);

  /**
   * * 添加数据
   *
   * @param obj
   * @return
   */
  @Override
  int add(AcProject obj);

  /**
   * 批量添加
   *
   * @param list
   * @return
   */
  @Override
  int batchAdd(List<AcProject> list);

  /** 物理删除，仅供测试清理数据 */
  @Override
  int deleteByPk(Long id);
}
