package com.zglu.mysqldao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Integer> {

    //原生sql关联查询
    @Query(nativeQuery = true,
            value = "select u.id,u.name,r.name roleName from user u " +
                    "left join (user_role ur join role r on ur.role_id=r.id) on u.id=ur.user_id " +
                    "where u.id=:id")
    List<Map> findUserRoleVoListById(@Param("id") int id);

    //hql关联查询
    @Query(value = "select new com.zglu.mysqldao.UserRoleVo(u,ur) from User u " +
            "left join com.zglu.mysqldao.UserRole ur on ur.userId=u.id " +
            "where u.id=:id")
    List<UserRoleVo> findUserRoleVoListForHqlById(@Param("id") int id);

    //hql查询vo
    @Query(value = "select u from User u " +
            "where u.id=:id")
    List<UserVo> findVoById(int id);

    //行级锁
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update user set enable=1 where enable=0")
    int update();
}
