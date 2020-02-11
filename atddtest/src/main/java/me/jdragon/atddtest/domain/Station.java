package me.jdragon.atddtest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author choijaeyong on 2020/02/11.
 * @project atddtest
 * @description
 */
@Getter
@NoArgsConstructor
@Entity
public class Station {
​
  @Id
  @GeneratedValue
  @Column(name = "station_id")
  private Long id;
​
  private String name;
​
  @Builder
  public Station(final String name) {
    this.name = name;
  }
}