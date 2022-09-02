package dev.edurevsky.requests.core.domain;

public class Request {

    private Long id;
    private String name;
    private Boolean done;

    public Request() {

    }

    public Request(Long id, String name, Boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public void update(String name, Boolean done) {
        this.name = name;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
