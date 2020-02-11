package me.jdragon.atddtest.domain;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "stations")
public class Station {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @Builder
  public Station(final String name) {
    this.name = name;
  }
}