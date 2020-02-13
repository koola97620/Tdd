package me.jdragon.atddtest.dao;

import me.jdragon.atddtest.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/02/13.
 * @project atddtest
 * @description
 */

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {

  Station save(Station station);
}
