package com.example.security;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	
    Optional<UserInfo> findByName(String username);

}
