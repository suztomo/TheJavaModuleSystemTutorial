module monitor.persistence {
  requires monitor.statistics;
  requires hibernate.jpa;
  exports monitor.persistence;
  exports monitor.persistence.entity;
}