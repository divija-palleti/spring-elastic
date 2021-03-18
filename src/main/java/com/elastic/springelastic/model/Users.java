package com.elastic.springelastic.model;

@Document(indexName = "users", shards = 1)
public class Users {

    @Id
    private String id;
    private String name;
    private String teamName;
    private Long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Users(String name, String id, String teamName, Long salary) {

        this.name = name;
        this.id = id;
        this.teamName = teamName;
        this.salary = salary;
    }

    public Users() {

    }
}