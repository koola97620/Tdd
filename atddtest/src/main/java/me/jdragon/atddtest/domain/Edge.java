package me.jdragon.atddtest.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Edge {	// 구간 (ex. A역 ↔︎ B역)
​
  @Id
  @GeneratedValue
  @Column(name = "edge_id")
  private Long id;
​
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "line_id")
  private Line line;
​
  private int elapsedTime;	// 소요시간(분)
​
  private int distance;		// 거리(km)
​
  // ???
  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "source_station_id")
  private Station sourceStation;
​
  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "target_station_id")
  private Station targetStation;
​
  // 이 구간에 2개 역을 등록
  public void setStations(Station sourceStation, Station targetStation) {
    this.sourceStation = sourceStation;
    this.targetStation = targetStation;
  }
​
  public void setLine(final Line line) {
    this.line = line;
  }
}
