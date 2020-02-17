package me.jdragon.atddsubway.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {


}
