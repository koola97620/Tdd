package me.jdragon.atddtest.dao;

import me.jdragon.atddtest.domain.Station;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/02/13.
 * @project atddtest
 * @description
 */

@Repository
public interface StationRepository {

  Station save(Station station);
}
