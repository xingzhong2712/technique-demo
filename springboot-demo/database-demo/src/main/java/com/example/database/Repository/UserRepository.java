package com.example.database.Repository;

import com.example.database.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 类职责：<br/>
 *
 * <p>Title: UserRepository.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年11月16日 下午下午 6:02
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {}