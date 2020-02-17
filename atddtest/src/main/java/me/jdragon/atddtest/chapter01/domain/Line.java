package me.jdragon.atddtest.chapter01.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "lines")
public class Line {
  @Id
  @GeneratedValue
  private Long id;

  private String name;		// 노선 이름(ex. 2호선)
  private String startTime;	// 첫차시간
  private String endTime;		// 막차시간
  private String intervals;	// 배차간격

  @OneToMany(mappedBy = "line")
  private List<Edge> edges = new ArrayList<>();

  // 이 지하철 노선(line)에 구간(edge)을 추가
  public void addEdge(Edge edge) {
    this.edges.add(edge);
    edge.setLine(this);
  }

  // 이 지하철 노선(line)에서 구간(edge)을 제거
  public void removeEdge(Edge edge) {
    this.edges.remove(edge);
    edge.setLine(null);
  }
}
